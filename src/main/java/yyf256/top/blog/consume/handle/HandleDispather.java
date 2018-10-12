package yyf256.top.blog.consume.handle;

import java.util.Date;

import yyf256.top.blog.consume.bean.HandleResult;
import yyf256.top.blog.consume.config.HandleProcessTypeContants;

public abstract class HandleDispather implements HandleProcessTypeContants{	
	/**
	 * 
	 * @param handle 处理类 
	 * @param processType 流程种类 
	 * @param time   时间
	 * @param money  金额
	 * @return
	 */
	public static HandleResult handle(DetailHandle handle,String processType,Date time,float money){
		switch (processType) {
		case UPDATE_DAILY_LOG:return handle.updateDailyLog(time, money);
		case UPDATE_MONTH_LOG:return handle.updateMonthLog(time, money);
		case UPDATE_MONTH_STANDARD:return handle.updateMonthStandard(time, money);
		default:
			return new HandleResult("没有找到执行方法");
		}
	}
	
	
}
