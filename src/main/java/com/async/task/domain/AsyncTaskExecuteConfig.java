package com.async.task.domain;

/**
 * @author liucc
 * 异步补偿任务配置项
 */
public class AsyncTaskExecuteConfig {

    /**
     * 最大执行次数
     */
    private Integer maxExecuteCount;

    /**
     * 最大超时时间
     * 单位,秒
     */
    private Long maxTimeOutSeconds;

    /**
     * 任务补偿频率
     * 单位,秒
     */
    private Long compensateRateSeconds;

}
