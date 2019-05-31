package yyf256.top.blog.service;

import java.util.Map;

public interface ConsumeService {
	/**
	 * 插入当日消费
	 * @param money 吃喝消费金额
	 * @return
	 */
	public Map<String,Object> insertConsume(String money,String token); 
	
	/**
	 * 插入当月最大消费标准
	 * @param eatMoney 吃喝消费标准
	 * @return
	 */
	public Map<String,Object> insertStandard(String eatMoney);
	
	/**
	 * 获取当月消费分析结果
	 * @return
	 */
	public Map<String,Object> getLogAnalysis();
}
