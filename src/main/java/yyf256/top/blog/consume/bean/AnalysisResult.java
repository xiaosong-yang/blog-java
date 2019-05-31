package yyf256.top.blog.consume.bean;

public class AnalysisResult {
	/**
	 * 是否获取数据成功
	 */
	private boolean isSuccess;
	/**
	 * 获取分析结果失败原因
	 */
	private String failReason;
	
	/**
	 * 月标准，两位小数
	 */
	private String monthStandard;
	/**
	 * 日均标准，两位小数
	 */
	private String dailyStandard;
	/**
	 * 已消费金额，两位小数
	 */
	private String alreadyConsume;
	/**
	 * 日均消费
	 */
	private String dailyConsume;
	/**
	 * 本月剩余金额，两位小数 (月标准-当月已消费)
	 */
	private String leftMoney;
	/**
	 * 节省金额，两位小数（日标准消费*天数-已消费金额），如果为负数表示超值的金额
	 */
	private String saveMoney;
	
	/**
	 * 默认获取数据成功的构造方法
	 * @param monthStandard
	 * @param dailyStandard
	 * @param alreadyConsume
	 * @param dailyConsume
	 * @param leftMoney
	 * @param saveMoney
	 */
	public AnalysisResult(String monthStandard, String dailyStandard, String alreadyConsume, String dailyConsume,
			String leftMoney, String saveMoney) {
		this.isSuccess=true;
		this.monthStandard = monthStandard;
		this.dailyStandard = dailyStandard;
		this.alreadyConsume = alreadyConsume;
		this.dailyConsume = dailyConsume;
		this.leftMoney = leftMoney;
		this.saveMoney = saveMoney;
	}
	
	/**
	 * 默认获取数据失败的构造方法
	 * @param failReason
	 */
	public AnalysisResult(String failReason) {
		this.isSuccess=false;
		this.failReason = failReason;
	}


	public String getMonthStandard() {
		return monthStandard;
	}
	public void setMonthStandard(String monthStandard) {
		this.monthStandard = monthStandard;
	}
	public String getDailyStandard() {
		return dailyStandard;
	}
	public void setDailyStandard(String dailyStandard) {
		this.dailyStandard = dailyStandard;
	}
	public String getAlreadyConsume() {
		return alreadyConsume;
	}
	public void setAlreadyConsume(String alreadyConsume) {
		this.alreadyConsume = alreadyConsume;
	}
	public String getDailyConsume() {
		return dailyConsume;
	}
	public void setDailyConsume(String dailyConsume) {
		this.dailyConsume = dailyConsume;
	}
	public String getLeftMoney() {
		return leftMoney;
	}
	public void setLeftMoney(String leftMoney) {
		this.leftMoney = leftMoney;
	}
	public String getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(String saveMoney) {
		this.saveMoney = saveMoney;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	@Override
	public String toString() {
		return "本月吃喝消费总标准为:￥"+monthStandard+",日标准为：￥"+dailyStandard+",已消费金额为：￥"+alreadyConsume+
				",日均消费金额为：￥"+dailyConsume+",剩余金额为：￥"+leftMoney+",节省金额为：￥"+saveMoney;
	}
	
	
}
