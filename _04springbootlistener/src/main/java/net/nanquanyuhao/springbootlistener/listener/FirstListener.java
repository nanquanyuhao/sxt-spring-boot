package net.nanquanyuhao.springbootlistener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Listener 方式一
 * <listener>
 *     <listener-class>net.nanquanyuhao.springbootlistener.listener.FirstListener</listener-class>
 * </listener>
 */
@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener...init...");
    }
}
