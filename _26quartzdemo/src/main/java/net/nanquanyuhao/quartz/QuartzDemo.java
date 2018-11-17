package net.nanquanyuhao.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * 定义任务类
 */
public class QuartzDemo implements Job {

    /**
     * 任务被触发时所执行的方法
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..." + new Date());
    }
}
