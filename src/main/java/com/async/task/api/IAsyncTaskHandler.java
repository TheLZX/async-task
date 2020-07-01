package com.async.task.api;

/**
 * @author liucc
 */
public interface IAsyncTaskHandler {

    /**
     * 异步补偿器
     */
    void asyncTaskExecutor();
}
