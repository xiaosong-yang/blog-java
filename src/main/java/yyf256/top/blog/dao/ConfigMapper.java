package yyf256.top.blog.dao;

import java.util.List;

import yyf256.top.blog.model.Config;

public interface ConfigMapper {
    int deleteByPrimaryKey(String key);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
    
    List<Config> getConfigs();
}