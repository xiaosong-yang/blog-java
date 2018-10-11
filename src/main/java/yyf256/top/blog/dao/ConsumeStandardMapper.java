package yyf256.top.blog.dao;

import yyf256.top.blog.model.ConsumeStandard;

public interface ConsumeStandardMapper {
    int deleteByPrimaryKey(String timeId);

    int insert(ConsumeStandard record);

    int insertSelective(ConsumeStandard record);

    ConsumeStandard selectByPrimaryKey(String timeId);

    int updateByPrimaryKeySelective(ConsumeStandard record);

    int updateByPrimaryKey(ConsumeStandard record);
}