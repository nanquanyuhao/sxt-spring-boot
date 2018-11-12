package net.nanquanyuhao.springbootlistener;

import net.nanquanyuhao.springbootlistener.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot 整合 Listener 方式二
 */
@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}

	@Bean
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SecondListener> bean = new ServletListenerRegistrationBean(new SecondListener());
		return bean;
	}
}
