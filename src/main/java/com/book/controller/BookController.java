package com.book.controller;

import com.book.entity.BookWarehouse;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.DataUtils;
import com.book.utils.Send;

import javax.lang.model.element.VariableElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookController")
public class BookController extends HttpServlet {
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private BookWarehouse bookWarehouse;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     if (req==null){
//         BookServiceImpl bookService = new BookServiceImpl();
//         DataUtils dataUtils=null;
//         //查询所有数据返回
//         List<BookWarehouse> bookWarehouses = bookService.selectBookall();
//         resp.setContentType(CONTENT_TYPE_JSON);
//         Send.sendJsonSucess(bookWarehouses);
//         Send.sendJsonError(bookWarehouses);
//     }else{
//
//
//     }
        //从前端获取的数据保存到实体类 传入service层
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        String bookName = req.getParameter("bookName");
        String bookAutor = req.getParameter("bookAutor");
        Integer bookCount = Integer.valueOf(req.getParameter("bookCount"));
        Integer bookLook = Integer.valueOf(req.getParameter("bookLook"));
        String bookTypeName = req.getParameter("bookTypeName");
        bookWarehouse = new BookWarehouse(bookId,bookName,bookAutor,bookCount,bookLook,bookTypeName);
        BookServiceImpl bookService = new BookServiceImpl();
        //调用服务层
        List<BookWarehouse> bookWarehouses = bookService.selectBookByCondition(bookWarehouse);

         resp.setContentType(CONTENT_TYPE_JSON);
        //发送json对象
         Send.sendJsonSucess(bookWarehouses);
         Send.sendJsonError(bookWarehouses);
    }



}
