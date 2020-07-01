package com.async.task.abstracts;

import com.async.task.api.IAsyncTaskHandler;
import com.async.task.domain.AsyncTaskExecuteConfig;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liucc
 * 异步任务核心处理类
 */
public abstract class AbstractAsyncTaskHandler implements IAsyncTaskHandler {

    /**
     * 异步补偿配置
     */
    private AsyncTaskExecuteConfig asyncTaskExecuteConfig;

    /**
     * 正向处理器
     */
    protected abstract void processor();

    /**
     * 后置异步任务补偿处理器
     */
    protected abstract void postCompensateAsyncTaskProcessor();

    /**
     * 异步任务执行器
     */
    @Override
    public void asyncTaskExecutor() {
        //0.执行正向业务流程
        this.processor();
        //1.将补偿任务放入线程池处理
        this.addAsyncTask2ThreadPool();
    }

    /**
     * 一级任务处理器
     */
    public void addAsyncTask2ThreadPool() {
        //0.包装一下补偿任务, 添加到线程池
        EXECUTOR_SERVICE.submit(this::postCompensateAsyncTaskProcessor);
    }

}
