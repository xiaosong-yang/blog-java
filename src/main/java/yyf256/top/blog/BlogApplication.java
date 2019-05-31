package yyf256.top.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @EnableScheduling在有任务计划的时候需要加上这个注解
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableScheduling
@ServletComponentScan(basePackages={"yyf256.top.blog"})
@ComponentScan(basePackages = {"yyf256.top.blog"})
@MapperScan(basePackages={"yyf256.top.blog.dao"})
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
