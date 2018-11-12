package net.nanquanyuhao.springbootlistener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Listener 方式二
 */
public class SecondListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener...init...");
    }
}
