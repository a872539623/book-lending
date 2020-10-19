package com.book.service.impl;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.entity.BookWarehouse;
import com.book.service.BookService;

import java.util.ArrayList;
import java.util.List;


public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();
    List<BookWarehouse> bookWarehouses = new ArrayList<>();


    @Override
    public List<BookWarehouse> selectBookAll() {
        //req对象不为空,调用dao层方方法获取查询出来的数据
        bookWarehouses = bookDao.selectBook();

        return bookWarehouses;
    }

    @Override
    public List<BookWarehouse> selectBookByCondition(BookWarehouse bookWarehouse) {

        List<BookWarehouse> bookWarehouses = bookDao.selectBookByCondition(bookWarehouse);

        return bookWarehouses;
    }
}
