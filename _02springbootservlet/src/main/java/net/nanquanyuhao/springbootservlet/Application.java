package net.nanquanyuhao.springbootservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot 整合 Servlet 方式一
 */
@SpringBootApplication
@ServletComponentScan // 在 SpringBoot 启动时会扫描 @WebServlet，并将该类初始化
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
