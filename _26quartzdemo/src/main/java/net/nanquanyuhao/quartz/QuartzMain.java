package net.nanquanyuhao.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by nanquanyuhao on 2018/11/17.
 */
public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {

        // 1.创建 Job 对象：你要做什么事？
        JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();

        /**
         * 简单的 trigger 触发时间：通过Quartz 提供一个方法来完成简单的重复调用 cron
         *
         * Trigger：按照Cron 的表达式来给定触发的时间
         */
        // 2.创建 Trigger 对象：在什么时间做？
        /*Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
                .build();*/

        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        // 3.创建 Scheduler 对象：在什么时间做什么事？
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);
        //启动
        scheduler.start();
    }
}
