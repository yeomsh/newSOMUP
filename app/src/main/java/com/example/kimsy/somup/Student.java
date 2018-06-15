package com.example.kimsy.somup;

import java.util.ArrayList;

public class Student {
    private String _id;
    private String _password;
    private String _name;
    private int _num;
    public ArrayList<String> subject;

    public Student() {
        this._id = null;
        this._password = null;
        this._name = null;
        this._num = -1;
    }

    public Student(String id, String password,String name,int num) {
        this._id = id;
        this._password = password;
        this._name = name;
        this._num = num;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_num() {
        return _num;
    }

    public void set_num(int _num) {
        this._num = _num;
    }

    public ArrayList<String> getSubject() {
        return subject;
    }

    public void setSubject(ArrayList<String> subject) {
        this.subject = subject;
    }
}
