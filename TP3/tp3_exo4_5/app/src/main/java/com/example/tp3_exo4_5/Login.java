package com.example.tp3_exo4_5;

import java.io.Serializable;

public class Login extends Object implements Serializable {
    private String name;
    private String lastname;
    private String tel;
    private String age;
    private  String password;

    public Login(String name, String lastname, String tel, String age, String password) {
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTel() {
        return tel;
    }

    public String getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}