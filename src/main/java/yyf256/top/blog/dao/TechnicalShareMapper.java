package yyf256.top.blog.dao;

import java.util.List;

import yyf256.top.blog.bean.TechncialType;
import yyf256.top.blog.bean.TechnicalSearch;
import yyf256.top.blog.model.TechnicalShare;
import yyf256.top.blog.model.TechnicalShareWithBLOBs;

public interface TechnicalShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TechnicalShareWithBLOBs record);

    int insertSelective(TechnicalShareWithBLOBs record);

    TechnicalShareWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TechnicalShareWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TechnicalShareWithBLOBs record);

    int updateByPrimaryKey(TechnicalShare record);
    
    Integer getCountByPage(TechnicalSearch search);
    
    List<TechnicalShareWithBLOBs> getTechShareByPage(TechnicalSearch search);
    
    List<TechncialType> getTechTypes();
}