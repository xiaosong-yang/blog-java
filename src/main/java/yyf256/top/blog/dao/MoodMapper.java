package yyf256.top.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yyf256.top.blog.model.Mood;

public interface MoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
    
    List<Mood> getNewestMoods(@Param("count")int count);
}