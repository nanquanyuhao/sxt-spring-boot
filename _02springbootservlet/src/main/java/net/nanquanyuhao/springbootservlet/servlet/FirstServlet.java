package net.nanquanyuhao.springbootservlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Servlet 方式一
 * <servlet>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <servlet-class>net.nanquanyuhao.springbootservlet.servlet.FirstServlet</servlet-class>
 * </servlet>
 *
 * <servlet-mapping>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <url-pattern>/first</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(name="FirstServlet", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet...");
    }
}
