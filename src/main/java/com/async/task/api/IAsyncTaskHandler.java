package com.async.task.api;

/**
 * @author liucc
 */
public interface IAsyncTaskHandler {

    /**
     * 正向处理器
     */
    void process();

    /**
     * 异步补偿器
     */
    void postAsyncTask();

    /**
     * 定时任务销毁器
     */
    void destoryAsyncTask();

}
