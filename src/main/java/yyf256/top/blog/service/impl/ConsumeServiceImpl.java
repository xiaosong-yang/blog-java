package yyf256.top.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.consume.bean.HandleResult;
import yyf256.top.blog.consume.config.HandleProcessTypeContants;
import yyf256.top.blog.consume.config.HandleSuccessTypeConstants;
import yyf256.top.blog.consume.handle.HandleDispather;
import yyf256.top.blog.consume.handle.impl.EatMoneyDetailHandle;
import yyf256.top.blog.dao.ConsumeLogMapper;
import yyf256.top.blog.dao.ConsumeMonthLogMapper;
import yyf256.top.blog.dao.ConsumeStandardMapper;
import yyf256.top.blog.model.ConsumeLog;
import yyf256.top.blog.model.ConsumeMonthLog;
import yyf256.top.blog.model.ConsumeStandard;
import yyf256.top.blog.service.ConsumeService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.MathUtil;

@Service
public class ConsumeServiceImpl implements ConsumeService{
	
	@Autowired
	private ConsumeMonthLogMapper consumeMonthLogMapper;
	
	@Autowired
	private EatMoneyDetailHandle eatMoneyDetailHandle;
	
	@Override
	public Map<String, Object> insertConsume(String money) {
		Map<String,Object> rs=new HashMap<>();
		try {
			float moneyFloat=Float.parseFloat(money);
			Date time=new Date();
			HandleResult result=HandleDispather.handle(eatMoneyDetailHandle,
					HandleProcessTypeContants.UPDATE_DAILY_LOG,
					time, moneyFloat);
			if(result.isSuccess()){
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, result.getOtherParams().get(HandleSuccessTypeConstants.SUCCESS_BACK_MSG));
			}else{
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
				rs.put(ResponseConfig.FAIL_REASON, result.getFailReason());
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
			HandleResult result=HandleDispather.handle(eatMoneyDetailHandle,
					HandleProcessTypeContants.UPDATE_MONTH_STANDARD, time, eatMoneyFloat);
			if(result.isSuccess()){
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, result.getOtherParams().get(HandleSuccessTypeConstants.SUCCESS_BACK_MSG));
			}else{
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
				rs.put(ResponseConfig.FAIL_REASON, result.getFailReason());
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
