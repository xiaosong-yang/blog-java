package yyf256.top.blog.dao;

import java.util.List;

import yyf256.top.blog.model.Diary;
import yyf256.top.blog.model.DiaryWithBLOBs;
import yyf256.top.blog.util.PageSearch;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiaryWithBLOBs record);

    int insertSelective(DiaryWithBLOBs record);

    DiaryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiaryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DiaryWithBLOBs record);

    int updateByPrimaryKey(Diary record);
    
    List<DiaryWithBLOBs> getDiaryByPage(PageSearch search);
    
    Integer getDiaryCount();
}