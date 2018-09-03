package com.carstation;

public class book {
    private String bookName;
    private int bookId;
    public book(){

    }
    public book(String name,int id){
        this.bookName=name;
        this.bookId=id;
    }
    public String getBookName(){
        return this.bookName;
    }
    public int getBookId(){
        return  this.bookId;
    }
}
