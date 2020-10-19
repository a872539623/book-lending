package com.book.dao;

import com.book.entity.BookWarehouse;

import java.util.List;

public interface BookDao {
    //根据传入的查询项进行查询
    List<BookWarehouse> selectBook();
    List<BookWarehouse> selectBookByCondition(BookWarehouse bookWarehouse);
}
