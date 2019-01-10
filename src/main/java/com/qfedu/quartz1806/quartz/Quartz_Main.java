package com.qfedu.quartz1806.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2019/1/10 14:53
 */
public class Quartz_Main {
    public static void main(String[] args) throws SchedulerException {
        //1、什么时间   触发器
        //间隔3秒
        Trigger trigger=TriggerBuilder.newTrigger().withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(2))
                .build();
        // * * * 1 * ?

        //2、创建作业详情 要干什么
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).build();

        //3、调度器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //将作业和触发器添加到调度器
        scheduler.scheduleJob(jobDetail,trigger);
        //启动
        scheduler.start();



    }
}
