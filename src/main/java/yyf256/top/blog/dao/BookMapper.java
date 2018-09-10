package yyf256.top.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yyf256.top.blog.bean.NearlyBook;
import yyf256.top.blog.model.Book;
import yyf256.top.blog.model.BookWithBLOBs;
import yyf256.top.blog.util.PageSearch;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    BookWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
    
    List<BookWithBLOBs> getBooksByPage(PageSearch search);
    
    Integer getBooksCount();
    
    List<NearlyBook> getNearlyBooks(@Param("count")int count);
}