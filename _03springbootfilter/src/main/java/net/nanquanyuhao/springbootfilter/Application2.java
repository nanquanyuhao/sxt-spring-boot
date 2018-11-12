package net.nanquanyuhao.springbootfilter;

import net.nanquanyuhao.springbootfilter.filter.SecondFilter;
import net.nanquanyuhao.springbootfilter.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot 整合 Servlet 方式二
 */
@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}

	/**
	 * 注册 Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");

		return bean;
	}

	/**
	 * 注册 Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		// bean.addUrlPatterns(new String[]{"*.do", "*.jsp"});
		bean.addUrlPatterns("/second");

		return bean;
	}
}
