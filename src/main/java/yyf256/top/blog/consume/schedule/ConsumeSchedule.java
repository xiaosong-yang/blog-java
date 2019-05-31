package yyf256.top.blog.consume.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import yyf256.top.blog.consume.config.ConsumeCoreConfig;
import yyf256.top.blog.util.EmailUtil;

@Component
public class ConsumeSchedule {
	
	@Scheduled(cron="0 30 21 * * ?")
	public void getMoneyInputSchedule(){
		String url="https://www.yyf256.top/blog/consume?token="+ConsumeCoreConfig.setAndGetToeken();
		String html="<a href='"+url+"'>消费录入入口</a>";
		String targetMail="867746360@qq.com";
		String title="录入消费记录啦";
		EmailUtil.sendMsg(targetMail, html, title);
	}
}
