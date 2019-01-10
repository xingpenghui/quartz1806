package com.qfedu.quartz1806.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2019/1/10 14:51
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //你想做的事情
        System.out.println("你即将拥有100万:"+System.currentTimeMillis()/1000);
    }
}
