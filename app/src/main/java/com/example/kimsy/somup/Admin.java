package com.example.kimsy.somup;

public class Admin {
    private String _id;
    private String _password;
    private String _name;
    private int _num;
    private String _level;

    public Admin(String id, String password,String name,int num) {
        this._id = id;
        this._password = password;
        this._name = name;
        this._num = num;
    }

    public Admin(String id, String password) {
        this._id = id;
        this._password = password;
        this._num = 20000000;
    }

    public void setID(String id){ this._id= id; }
    public String get_id(){
        return _id;
    }
    public void setLevel(String level){ this._level= level; }
    public String get_level(){ return _level; }
    public String get_name(){ return _name; }
    public int get_num(){return _num; }
    public void setProductName(String password){
        this._password = password;
    }
    public String get_password(){
        return _password;
    }

}
