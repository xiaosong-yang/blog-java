package yyf256.top.blog.dao;


import yyf256.top.blog.bean.FaceImg;

import java.util.List;

public interface FaceImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FaceImg record);

    int insertSelective(FaceImg record);

    FaceImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaceImg record);

    int updateByPrimaryKey(FaceImg record);

    List<FaceImg> getImgsOrderByIndex();
}