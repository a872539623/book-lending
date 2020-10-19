package com.book.dao.impl;

import com.book.dao.BookDao;
import com.book.entity.BookWarehouse;
import com.book.utils.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private List<BookWarehouse> list = new ArrayList<>();
    private  BookWarehouse bookWarehouse = new BookWarehouse();
    @Override
    public List<BookWarehouse> selectBook() {

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        String sql="select book_id,BOOK_name,book_autor,book_count,book_look,book_type_name from book_warehouse where book_count=?";
        BookWarehouse bookWarehouse;
        try {
            //执行sql语句并返回结果集
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,10);
            rs=ps.executeQuery();
            //遍历结果集
            while(rs.next()) {
                int bookId = rs.getInt(1);
                String BookName = rs.getString(2);
                String BookAutor = rs.getString(3);
                int BookCount = rs.getInt(4);
                int BookLook = rs.getInt(5);
                String BookTypeName = rs.getString(6);
                bookWarehouse= new BookWarehouse(bookId, BookName,BookAutor,BookCount,BookLook,BookTypeName);
                list.add(bookWarehouse);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookWarehouse> selectBookByCondition(BookWarehouse bookWarehouse) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        String sql="select book_id,BOOK_name,book_autor,book_count,book_look,book_type_name from book_warehouse where ";

        String newSql = null;
        //获取前端输入的条件
        int bookId = bookWarehouse.getBookId();
        String bookName = bookWarehouse.getBookName();
        String bookAutor = bookWarehouse.getBookAutor();
        int bookCount = bookWarehouse.getBookCount();
        int bookLook = bookWarehouse.getBookLook();
        String bookTypeName = bookWarehouse.getBookTypeName();
        if (bookId != 0) {
            newSql = sql.concat("book_id=" + bookId + ",");
        }
        if (bookName != null) {
            newSql = newSql.concat("BOOK_name=" + bookName + ",");
        }
        if (bookAutor != null) {
            newSql = newSql.concat("book_autor=" + bookAutor + ",");
        }
        if (bookCount >=0) {
            newSql = newSql.concat("book_count=" + bookCount + ",");
        }
        if (bookLook==0||bookLook==1) {
            newSql = newSql.concat("book_look=" + bookLook + ",");
        }
        if (bookTypeName != null) {
            newSql = newSql.concat("book_type_name=" + bookTypeName + ",");
        }

        //创建stringBuffer对象用delectCharAt方法 删除最后一个","号
        StringBuffer stringBuffer = new StringBuffer(newSql);
        //删除后重新转换成String类型字符串
        String finalSql = new String(stringBuffer.deleteCharAt(stringBuffer.length() - 1));
        try {
            //执行sql语句并返回结果集
            conn= DBUtils.getConnection();
            ps=conn.prepareStatement(finalSql);

            rs=ps.executeQuery();
            //遍历结果集
            while(rs.next()) {
                bookId = rs.getInt(1);
                String BookName = rs.getString(2);
                String BookAutor = rs.getString(3);
                int BookCount = rs.getInt(4);
                int BookLook = rs.getInt(5);
                String BookTypeName = rs.getString(6);
                bookWarehouse= new BookWarehouse(bookId, BookName,BookAutor,BookCount,BookLook,BookTypeName);
                list.add(bookWarehouse);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
