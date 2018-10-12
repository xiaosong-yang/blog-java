package yyf256.top.blog.consume.handle.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.consume.bean.HandleResult;
import yyf256.top.blog.consume.config.HandleSuccessTypeConstants;
import yyf256.top.blog.consume.handle.DetailHandle;
import yyf256.top.blog.dao.ConsumeLogMapper;
import yyf256.top.blog.dao.ConsumeMonthLogMapper;
import yyf256.top.blog.dao.ConsumeStandardMapper;
import yyf256.top.blog.model.ConsumeLog;
import yyf256.top.blog.model.ConsumeMonthLog;
import yyf256.top.blog.model.ConsumeStandard;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.MathUtil;

@Component
public class EatMoneyDetailHandle implements DetailHandle{
	
	@Autowired
	private ConsumeLogMapper consumeLogMapper;
	
	@Autowired
	private ConsumeMonthLogMapper consumeMonthLogMapper;
	
	@Autowired
	private ConsumeStandardMapper consumeStandardMapper;
	
	@Override
	@Transactional
	public HandleResult updateDailyLog(Date time, float money) {
		String timeId=DateUtil.DateToStr(time, "yyyyMMdd");
		HandleResult result;
		ConsumeLog log=consumeLogMapper.selectByPrimaryKey(timeId);
		if(log!=null){
			float lastMoney=log.getConsume1();
			log.setConsume1(money);
			consumeLogMapper.updateByPrimaryKeySelective(log);
			String backMsg="当天消费记录已存在,消费金额为：￥"
					+ MathUtil.formatFloat(lastMoney, "0.00")+"，本次操作将金额修改为:￥"
					+MathUtil.formatFloat(money, "0.00");
			float changeMoney=money-lastMoney;
			result=updateMonthLog(time, changeMoney);
			result.getOtherParams().put(HandleSuccessTypeConstants.SUCCESS_BACK_MSG, backMsg+";"+
					result.getOtherParams().get(HandleSuccessTypeConstants.SUCCESS_BACK_MSG));
		}else{
			log=new ConsumeLog();
			log.setConsume1(money);
			log.setTime(time);
			log.setTimeId(timeId);
			String monthId=DateUtil.DateToStr(time, "yyyyMM");
			log.setMonthId(monthId);
			consumeLogMapper.insertSelective(log);
			String backMsg="今日消费金额:￥"+MathUtil.formatFloat(money, "0.00")+"存储成功";
			result=updateMonthLog(time, money);
			result.getOtherParams().put(HandleSuccessTypeConstants.SUCCESS_BACK_MSG, backMsg+";"+
					result.getOtherParams().get(HandleSuccessTypeConstants.SUCCESS_BACK_MSG));
		}
		return result;
	}

	@Override
	public HandleResult updateMonthLog(Date time, float money) {
		Map<String,Object> otherParams=new HashMap<>();
		String monthId=DateUtil.DateToStr(time, "yyyyMM");
		ConsumeMonthLog monthLog = consumeMonthLogMapper.selectByPrimaryKey(monthId);
		if(monthLog==null){
			monthLog = new ConsumeMonthLog();
			monthLog.setTimeId(monthId);
			monthLog.setUpdateTime(time);
			monthLog.setConsume1(money);
			consumeMonthLogMapper.insertSelective(monthLog);

		}else{
			monthLog.setUpdateTime(time);
			float lastMoney=monthLog.getConsume1();
			monthLog.setConsume1(lastMoney+money);
			consumeMonthLogMapper.updateByPrimaryKeySelective(monthLog);
		}
		otherParams.put(HandleSuccessTypeConstants.SUCCESS_BACK_MSG, "当月吃喝消费金额已更新为：￥" + MathUtil.formatFloat(monthLog.getConsume1(), "0.00"));
		return new HandleResult(true,null,otherParams);
	}

	@Override
	public HandleResult updateMonthStandard(Date time, float money) {
		Map<String,Object> otherParams=new HashMap<>();
		String timeId=DateUtil.DateToStr(time, "yyyyMM");
		ConsumeStandard standard=consumeStandardMapper.selectByPrimaryKey(timeId);
		if(standard!=null){
			float lastEatMoney=standard.getComsume1();
			standard.setComsume1(money);
			consumeStandardMapper.updateByPrimaryKeySelective(standard);
			otherParams.put(HandleSuccessTypeConstants.SUCCESS_TYPE, HandleSuccessTypeConstants.SUCCESS_UPDATE);
			otherParams.put(ResponseConfig.RSP_CONTENT, "当月消费标准已经存在：吃喝标准为:￥"
					+ MathUtil.formatFloat(lastEatMoney, "0.00")+",现当月消费标准已被修改，如下：￥"+
					MathUtil.formatFloat(money, "0.00"));
		}else{
			standard=new ConsumeStandard();
			standard.setTimeId(timeId);
			standard.setUpdateTime(time);
			standard.setComsume1(money);
			consumeStandardMapper.insertSelective(standard);
			otherParams.put(HandleSuccessTypeConstants.SUCCESS_TYPE, HandleSuccessTypeConstants.SUCCESS_INSERT);
			otherParams.put(ResponseConfig.RSP_CONTENT, "当月消费标准设定成功，吃喝标准：￥"+
					MathUtil.formatFloat(money, "0.00"));
		}
		return new HandleResult(true, null, otherParams);
	}
	
}
