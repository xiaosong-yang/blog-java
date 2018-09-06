package yyf256.top.blog.dao;

import yyf256.top.blog.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer versionId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer versionId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    UserInfo getNewestInfo();
}