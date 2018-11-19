package net.nanquanyuhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.nanquanyuhao.mapper") // @MapperScan 告知接口扫描时的位置，据接口生成代理对象
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
