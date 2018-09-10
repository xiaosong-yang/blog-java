package yyf256.top.blog.dao;

import java.util.List;

import yyf256.top.blog.model.Dota;
import yyf256.top.blog.model.DotaWithBLOBs;
import yyf256.top.blog.util.PageSearch;

public interface DotaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DotaWithBLOBs record);

    int insertSelective(DotaWithBLOBs record);

    DotaWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DotaWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DotaWithBLOBs record);

    int updateByPrimaryKey(Dota record);
    
    Integer getDotaDiaryCount();
    
    List<DotaWithBLOBs> getDotaDiarys(PageSearch search);
}