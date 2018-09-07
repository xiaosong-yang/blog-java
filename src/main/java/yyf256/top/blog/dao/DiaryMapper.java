package yyf256.top.blog.dao;

import yyf256.top.blog.model.Diary;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKeyWithBLOBs(Diary record);

    int updateByPrimaryKey(Diary record);
}