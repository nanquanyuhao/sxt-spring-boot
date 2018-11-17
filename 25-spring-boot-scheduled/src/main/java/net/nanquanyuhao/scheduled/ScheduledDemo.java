package net.nanquanyuhao.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * Scheduled 定时任务
 */
@Component
public class ScheduledDemo {

    /**
     * 定时任务方法
     *
     * @Scheduled：设置定时任务 cron 属性：cron 表达式。定时任务触发是时间的一个字符串表达形式
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod() {
        System.out.println("定时器被触发" + new Date());
    }
}
