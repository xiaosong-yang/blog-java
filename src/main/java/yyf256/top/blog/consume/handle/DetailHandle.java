package yyf256.top.blog.consume.handle;

import java.util.Date;

import yyf256.top.blog.consume.bean.AnalysisResult;
import yyf256.top.blog.consume.bean.HandleResult;

public interface DetailHandle {
	/**
	 * 更新日消费记录
	 * @param time
	 * @param money
	 * @return
	 */
	public abstract HandleResult updateDailyLog(Date time,float money);
	/**
	 * 更新月消费记录
	 * @param time
	 * @param money
	 * @return
	 */
	public abstract HandleResult updateMonthLog(Date time,float money);
	/**
	 * 更新月消费标准
	 * @param time
	 * @param money
	 * @return
	 */
	public abstract HandleResult updateMonthStandard(Date time,float money);
	/**
	 * 获取分析结果
	 * @param time 时间
	 * @return 返回不会为空，根据isSuccess判断成功与否
	 */
	public abstract AnalysisResult getAnalysisResult(Date time);
}
