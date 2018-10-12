package yyf256.top.blog.consume.config;
/**
 * 消费金额处理成功分两种，第一种成功将数据插入到数据库中，
 * 第二种是数据库中已经存在数据，成功将数据进行了修改
 * @author addddd
 *
 */
public interface HandleSuccessTypeConstants {
	/**
	 * 处理成功种类
	 */
	public static final String SUCCESS_TYPE="successType";
	/**
	 * 成功插入数据
	 */
	public static final String SUCCESS_INSERT="successInsert";
	/**
	 * 成功更新数据
	 */
	public static final String SUCCESS_UPDATE="successUpdate";
	/**
	 * 成功时返回的消息
	 */
	public static final String SUCCESS_BACK_MSG="succesBackMsg";
}
