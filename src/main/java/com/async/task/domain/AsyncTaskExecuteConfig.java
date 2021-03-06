package com.async.task.domain;

import lombok.Data;

/**
 * @author liucc
 * 异步补偿任务配置项
 */
@Data
public class AsyncTaskExecuteConfig {

    /**
     * 最大执行次数
     */
    public Integer maxExecuteCount;

    /**
     * 最大超时时间
     * 单位,秒
     */
    public Long maxTimeOutSeconds;

    /**
     * 任务补偿频率
     * 单位,秒
     */
    public Long compensateRateSeconds;

}
