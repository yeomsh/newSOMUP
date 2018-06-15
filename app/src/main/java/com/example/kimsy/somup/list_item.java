package com.example.iuhoo.myapplication;

public class list_item {
    private String bookname;
    private int count;
    private String title;

    public list_item(String bookname, int count,  String title) {
        this.bookname = bookname;
        this.count = count;
        this.title = title;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void plusCount(){
        count++;
    }

    public void minusCount(){
        count--;
    }
}
