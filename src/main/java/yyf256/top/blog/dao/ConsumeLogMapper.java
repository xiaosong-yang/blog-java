package yyf256.top.blog.dao;

import yyf256.top.blog.model.ConsumeLog;

public interface ConsumeLogMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeLog record);

    int insertSelective(ConsumeLog record);

    ConsumeLog selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeLog record);

    int updateByPrimaryKey(ConsumeLog record);
}