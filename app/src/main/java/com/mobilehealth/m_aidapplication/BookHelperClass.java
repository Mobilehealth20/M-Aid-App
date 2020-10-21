package com.mobilehealth.m_aidapplication;

public class BookHelperClass {

    String name, id, no, mail, date;

    public BookHelperClass() {

    }

    public BookHelperClass(String name, String id, String no, String mail, String date) {
        this.name = name;
        this.id = id;
        this.no = no;
        this.mail = mail;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
