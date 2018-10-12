package yyf256.top.blog.dao;

import yyf256.top.blog.model.ConsumeMonthLog;

public interface ConsumeMonthLogMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeMonthLog record);

    int insertSelective(ConsumeMonthLog record);

    ConsumeMonthLog selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeMonthLog record);

    int updateByPrimaryKey(ConsumeMonthLog record);
}