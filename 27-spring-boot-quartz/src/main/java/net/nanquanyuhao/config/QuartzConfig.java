package net.nanquanyuhao.config;

import net.nanquanyuhao.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * Quartz 配置类
 */
@Configuration
public class QuartzConfig {

    /**
     * 1. 创建 Job 对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {

        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        // 关联我们自己的 Job 类
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }

    /**
     * 2. 创建 Trigger 对象
     * <p>
     * 简单的 Trigger
     */
    /*@Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();

        // 关联JobDetail 对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        // 该参数表示一个执行的毫秒数
        factory.setRepeatInterval(2000);
        // 重复次数
        factory.setRepeatCount(5);

        return factory;
    }*/

    /**
     * Cron Trigger
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();

        // 关联 JobDetail 对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        // 设置触发时间
        factory.setCronExpression("0/2 * * * * ?");

        return factory;
    }

    /**
     * 3. 创建 Scheduler 对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory) {

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 关联 trigger
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        // 设置使用自己重写了实例化 job 方法的 job 工厂
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }
}
