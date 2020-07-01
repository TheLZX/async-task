package com.async.task.abstracts;

import com.async.task.api.IAsyncTaskHandler;
import com.async.task.domain.AsyncTaskExecuteConfig;
import com.async.task.enums.TaskStatusEnum;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author liucc
 * 异步任务核心处理类
 */
public abstract class AbstractAsyncTaskHandler implements IAsyncTaskHandler {

    /**
     * 任务池
     */
    private static final ThreadFactory NAMED_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("pool-sendsms-").build();
    private static final ScheduledThreadPoolExecutor EXECUTOR_SERVICE =
            new ScheduledThreadPoolExecutor(10, NAMED_THREAD_FACTORY);

    /**
     * 任务状态
     */
    private TaskStatusEnum taskStatusInstance = TaskStatusEnum.U;

    /**
     * 异步补偿配置
     */
    private AsyncTaskExecuteConfig executeConfig;

    /**
     * 正向处理器
     */
    protected abstract void processor();

    /**
     * 后置异步任务补偿处理器
     */
    protected abstract void postCompensateProcessor();

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
     * 添加到任务执行队列中
     */
    public void addAsyncTask2ThreadPool() {
        //0.任务状态非初始化不执行
        if (!TaskStatusEnum.checkIfNeedContinueExecute(taskStatusInstance)) {
            return;
        }
        //1.设置任务为处理中
        this.taskStatusInstance = TaskStatusEnum.P;
        //1.包装一下补偿任务, 添加到指定任务
        EXECUTOR_SERVICE.scheduleWithFixedDelay(this::postCompensateProcessor, executeConfig.compensateRateSeconds, executeConfig.compensateRateSeconds, TimeUnit.SECONDS);
    }

    /**
     *
     */
    private Runnable buildCompensateRunningCommand() {

        return null;
    }


}
