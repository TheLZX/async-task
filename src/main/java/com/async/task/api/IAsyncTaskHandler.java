package com.async.task.api;

/**
 * @author liucc
 */
public interface IAsyncTaskHandler {

    /**
     * 正向处理器
     */
    void processor();

    /**
     * 异步补偿器
     */
    void postAsyncTaskProcessor();

}
