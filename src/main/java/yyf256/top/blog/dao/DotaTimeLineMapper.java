package yyf256.top.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yyf256.top.blog.model.DotaTimeLine;

public interface DotaTimeLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DotaTimeLine record);

    int insertSelective(DotaTimeLine record);

    DotaTimeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DotaTimeLine record);

    int updateByPrimaryKeyWithBLOBs(DotaTimeLine record);

    int updateByPrimaryKey(DotaTimeLine record);
    
    List<DotaTimeLine> getDataTimeLine(@Param("count")int count);
}