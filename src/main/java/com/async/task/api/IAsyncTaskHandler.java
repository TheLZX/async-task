package com.async.task.api;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author liucc
 */
public interface IAsyncTaskHandler {

    /**
     * 公共任务池
     */
    ThreadFactory NAMED_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("pool-async-task-").build();
    ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 10, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(120), NAMED_THREAD_FACTORY);

    /**
     * 异步补偿器
     */
    void asyncTaskExecutor();

}
