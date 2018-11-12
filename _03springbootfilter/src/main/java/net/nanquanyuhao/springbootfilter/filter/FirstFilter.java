package net.nanquanyuhao.springbootfilter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Filter 方式一
 * <filter>
 *     <filter-name>FirstFilter</filter-name>
 *     <filter-class>net.nanquanyuhao.springbootfilter.filter.FirstFilter</filter-class>
 * </filter>
 *
 * <filter-mapping>
 *     <filter-name>FirstFilter</filter-name>
 *     <url-pattern>/first</url-pattern>
 * </filter-mapping>
 */
// @WebFilter(filterName = "FirstServlet", urlPatterns = {"*.do", "*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入 Filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开 Filter");
    }

}
