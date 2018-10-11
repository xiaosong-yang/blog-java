package yyf256.top.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.ConsumeLogMapper;
import yyf256.top.blog.dao.ConsumeStandardMapper;
import yyf256.top.blog.model.ConsumeLog;
import yyf256.top.blog.model.ConsumeStandard;
import yyf256.top.blog.service.ConsumeService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.MathUtil;

@Service
public class ConsumeServiceImpl implements ConsumeService{

	@Autowired
	private ConsumeLogMapper consumeLogMapper;
	
	@Autowired
	private ConsumeStandardMapper consumeStandardMapper;
	
	@Override
	public Map<String, Object> insertConsume(String money) {
		Map<String,Object> rs=new HashMap<>();
		try {
			float moneyFloat=Float.parseFloat(money);
			Date time=new Date();
			String timeId=DateUtil.DateToStr(time, "yyyyMMdd");
			ConsumeLog log=consumeLogMapper.selectByPrimaryKey(timeId);
			if(log!=null){
				float lastMoney=log.getConsumeMoney();
				log.setConsumeMoney(moneyFloat);
				consumeLogMapper.updateByPrimaryKey(log);
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, "当天消费记录已存在,消费金额为：￥"
						+ MathUtil.formatFloat(lastMoney, "0.00")+"，本次操作将金额修改为:￥"
						+MathUtil.formatFloat(moneyFloat, "0.00"));
			}else{
				log=new ConsumeLog();
				log.setConsumeMoney(moneyFloat);
				log.setTime(time);
				log.setTimeId(timeId);
				consumeLogMapper.insert(log);
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, "今日消费金额存储成功");
			}
		} catch (NumberFormatException e) {
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "录入金额异常，请重新录入");
		}
		return rs;
	}

	@Override
	public Map<String, Object> insertStandard(String eatMoney) {
		Map<String,Object> rs=new HashMap<>();
		try {
			float eatMoneyFloat=Float.parseFloat(eatMoney);
			Date time=new Date();
			String timeId=DateUtil.DateToStr(time, "yyyyMM");
			ConsumeStandard standard=consumeStandardMapper.selectByPrimaryKey(timeId);
			if(standard!=null){
				float lastEatMoney=standard.getComsume1();
				standard.setComsume1(eatMoneyFloat);
				consumeStandardMapper.updateByPrimaryKeySelective(standard);
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, "当月消费标准已经存在：吃喝标准为:￥"
						+ MathUtil.formatFloat(lastEatMoney, "0.00")+",现当月消费标准已被修改，如下：￥"+
						MathUtil.formatFloat(eatMoneyFloat, "0.00"));
			}else{
				standard=new ConsumeStandard();
				standard.setTimeId(timeId);
				standard.setUpdateTime(time);
				standard.setComsume1(eatMoneyFloat);
				consumeStandardMapper.insertSelective(standard);
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, "当月消费标准设定成功，吃喝标准：￥"+
						MathUtil.formatFloat(eatMoneyFloat, "0.00"));
			}
		} catch (NumberFormatException e) {
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "录入金额异常，请重新录入");
		}
		return rs;
	}

	@Override
	public Map<String, Object> getLogAnalysis() {
		int days=DateUtil.getCurrentMonthLastDay();
		return null;
	}

}
