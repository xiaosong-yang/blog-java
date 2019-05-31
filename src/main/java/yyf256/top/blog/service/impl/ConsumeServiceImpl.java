package yyf256.top.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.consume.bean.AnalysisResult;
import yyf256.top.blog.consume.bean.HandleResult;
import yyf256.top.blog.consume.bean.TokenCheckResult;
import yyf256.top.blog.consume.config.ConsumeCoreConfig;
import yyf256.top.blog.consume.config.HandleSuccessTypeConstants;
import yyf256.top.blog.consume.handle.DetailHandle;
import yyf256.top.blog.service.ConsumeService;

@Service
public class ConsumeServiceImpl implements ConsumeService{
	
	@Resource(name="eatMoneyHandle")
	private DetailHandle eatMoneyDetailHandle;
	
	@Override
	public Map<String, Object> insertConsume(String money,String token) {
		TokenCheckResult tokenRs=isTokenCorrect(token);
		Map<String,Object> rs=new HashMap<>();
		if(!tokenRs.isCorrect()){
			return tokenRs.getResult();
		}
		try {
			float moneyFloat=Float.parseFloat(money);
			Date time=new Date();
			HandleResult result=eatMoneyDetailHandle.updateDailyLog(time, moneyFloat);
			if(result.isSuccess()){
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				Map<String,Object> content=new HashMap<>(); 
				String successBackMsg=(String) result.getOtherParams().get(HandleSuccessTypeConstants.SUCCESS_BACK_MSG);
				successBackMsg=successBackMsg+";"+eatMoneyDetailHandle.getAnalysisResult(time).toString();
				content.put("successMsg", successBackMsg);
				content.put("newToken", tokenRs.getNewToken());
				rs.put(ResponseConfig.RSP_CONTENT, content);
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
			HandleResult result=eatMoneyDetailHandle.updateMonthStandard(time, eatMoneyFloat);
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
		Date time=new Date();
		Map<String,Object> rs=new HashMap<>();
		AnalysisResult analysisResult=eatMoneyDetailHandle.getAnalysisResult(time);
		if(analysisResult.isSuccess()){
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, analysisResult.toString());
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, analysisResult.getFailReason());
		}
		return rs;
	}
	/**
	 * token为null表示从
	 * @param token
	 * @return
	 */
	private TokenCheckResult isTokenCorrect(String token){
		if(ConsumeCoreConfig.tokenIsCorrect(token)){
			return new TokenCheckResult(ConsumeCoreConfig.setAndGetToeken());
		}
		Map<String,Object> rs=new HashMap<>();
		rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
		rs.put(ResponseConfig.FAIL_REASON, "token验证不正确");
		return new TokenCheckResult(rs);
	}

}
