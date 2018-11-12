package net.nanquanyuhao.springbootfilter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot 整合 Servlet 方式一
 */
public class SecondServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SecondServlet...");
    }
}
