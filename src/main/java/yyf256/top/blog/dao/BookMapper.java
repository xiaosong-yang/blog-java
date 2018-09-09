package yyf256.top.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yyf256.top.blog.bean.NearlyBook;
import yyf256.top.blog.model.Book;
import yyf256.top.blog.util.PageSearch;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List<Book> getBooksByPage(PageSearch search);
    
    List<NearlyBook> getNearlyBooks(@Param("count")int count);
}