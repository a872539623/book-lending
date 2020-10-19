package com.book.service;

import com.book.entity.BookWarehouse;

import java.util.List;

public interface BookService {
    List<BookWarehouse> selectBookAll();
    List<BookWarehouse> selectBookByCondition(BookWarehouse bookWarehouse);

}
