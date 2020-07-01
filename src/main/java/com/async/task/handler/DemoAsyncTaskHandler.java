package com.async.task.handler;

import com.async.task.abstracts.AbstractAsyncTaskHandler;

/**
 * @author liucc
 * 实例处理类
 */
public class DemoAsyncTaskHandler extends AbstractAsyncTaskHandler {
    @Override
    protected void processor() {
        System.out.println("订单支付中...");
    }

    @Override
    protected void postCompensateAsyncTaskProcessor() {
        System.out.println("订单支付成功!");
    }
}
