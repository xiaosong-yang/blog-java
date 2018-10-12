package yyf256.top.blog.consume.handle;

import java.util.Date;

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
}
