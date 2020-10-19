package com.book.entity;


import java.util.Objects;


public class BookWarehouse {
    private int bookId;
    private String bookName;
    private String bookAutor;
    private Integer bookCount;
    private Integer bookLook;
    private String bookTypeName;

    public BookWarehouse() {
    }

    public BookWarehouse(int bookId, String bookName, String bookAutor, Integer bookCount, Integer bookLook, String bookTypeName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAutor = bookAutor;
        this.bookCount = bookCount;
        this.bookLook = bookLook;
        this.bookTypeName = bookTypeName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAutor() {
        return bookAutor;
    }

    public void setBookAutor(String bookAutor) {
        this.bookAutor = bookAutor;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getBookLook() {
        return bookLook;
    }

    public void setBookLook(Integer bookLook) {
        this.bookLook = bookLook;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }
}
