package com.qfedu.quartz1806.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2019/1/10 14:53
 */
public class Quartz_Main2 {
    public static void main(String[] args) throws SchedulerException {
        //1、什么时间   触发器
        String cron1="0/5 * * 10 * ?";  //每月10号，每隔秒执行一次
        String cron2="0 1/1 15-17 10 * ?";  //每月10号，每隔秒执行一次
        //间隔3秒
        Trigger trigger=TriggerBuilder.newTrigger().withSchedule(
                 CronScheduleBuilder.cronSchedule(cron2))
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
