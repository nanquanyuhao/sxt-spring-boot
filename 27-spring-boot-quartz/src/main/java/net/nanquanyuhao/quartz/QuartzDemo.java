package net.nanquanyuhao.quartz;

import net.nanquanyuhao.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * Job 类
 */
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..." + new Date());
        this.userService.addUser();
    }
}
