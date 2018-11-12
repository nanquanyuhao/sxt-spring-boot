package net.nanquanyuhao.springbootfilter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Filter 方式二
 */
public class SecondFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入 SecondFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开 SecondFilter");
    }

}
