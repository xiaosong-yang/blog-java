package yyf256.top.blog.util;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 需要结合mail.jar使用，maven如下
 		<dependency>
			<groupId>javax.mail</groupId>
			<artifactId>mail</artifactId>
			<version>1.4</version>
		</dependency>
 * @author addddd
 *
 */
public class EmailUtil {
    private static final String ALIDM_SMTP_HOST = "smtpdm.aliyun.com";
    /**
     * "25"或"80"(由于阿里禁用了25端口，只能使用80了)
     */
    private static final String ALIDM_SMTP_PORT = "80";
    /**
     * 邮箱账户，在阿里云邮件推送功能里设置的
     */
    private static final String MAIL_USER ="xiaosong@yyf256.top";
    /**
     * 邮箱密码，在阿里云邮件推送功能里设置的
     */
    private static final String PASSWORD = "LOVELlovel8023";
    /**
     * 回信的回调信箱，在阿里云邮件推送功能里设置的
     */
    private static final String CALLBACK_USER ="867746360@qq.com";
    /**
     * 这个可以自定义设置
     */
    private static final String MAIL_USER_NAME ="xiao_Y的个人博客";
    
    public static boolean sendMsg(String email,String html_msg,String title){
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        // 发件人的账号，填写控制台配置的发信地址,比如xxx@xxx.com
        props.put("mail.user", MAIL_USER);
        // 访问SMTP服务时需要提供的密码(在控制台选择发信地址进行设置)
        props.put("mail.password", PASSWORD);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
//        mailSession.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {
        // 设置发件人邮件地址和名称。填写控制台配置的发信地址,比如xxx@xxx.com。和上面的mail.user保持一致。名称用户可以自定义填写。
        InternetAddress from=null;
		try {
			from = new InternetAddress(MAIL_USER, MAIL_USER_NAME);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
        message.setFrom(from);
        //可选。设置回信地址
        Address[] a = new Address[1];
        a[0] = new InternetAddress(CALLBACK_USER);
        message.setReplyTo(a);
        // 设置收件人邮件地址，比如yyy@yyy.com
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        //如果同时发给多人，才将上面两行替换为如下（因为部分收信系统的一些限制，尽量每次投递给一个人；同时我们限制单次允许发送的人数是30人）：
        //InternetAddress[] adds = new InternetAddress[2];
        //adds[0] = new InternetAddress("xxxxx@qq.com");
        //adds[1] = new InternetAddress("xxxxx@qq.com");
        //message.setRecipients(Message.RecipientType.TO, adds);
        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件的内容体
        message.setContent(html_msg, "text/html;charset=UTF-8");
        // 发送邮件
        Transport.send(message);
        }
        catch (MessagingException e) {
            String err = e.getMessage();
            // 在这里处理message内容， 格式是固定的
            System.out.println(err);
			return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	EmailUtil.sendMsg("867746360@qq.com", "123456","注册验证");
    }
}
