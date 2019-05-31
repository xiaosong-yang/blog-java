package yyf256.top.blog;

import java.util.Date;

import yyf256.top.blog.util.DateUtil;

public class DateTest {
	public static void main(String[] args) {
		System.out.println("当月天数="+DateUtil.getMonthLastDay(new Date()));
		System.out.println("当月天数="+DateUtil.getCurrentMonthLastDay());
		System.out.println("当月天数="+DateUtil.getMonthDay(new Date()));
	}
}
