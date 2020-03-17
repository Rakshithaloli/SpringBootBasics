package com.softeck.valreturn;

public class Topics {

    private String id;
    private String bookname;
    private  String description;
    public Topics(){

    }

    public Topics(String id, String bookname, String description) {
        this.id = id;
        this.bookname = bookname;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
