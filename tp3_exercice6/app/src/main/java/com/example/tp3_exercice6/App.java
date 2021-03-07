package com.example.tp3_exercice6;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Application")
public class App {
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "number")
    private int number;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "lastname")
    private String lastname;

    @ColumnInfo(name = "age")
    private String age;

    @ColumnInfo(name = "telephone")
    private String telephone;

    @ColumnInfo(name = "cal")
    private String cal;

    public App(int id, int number, String name, String lastname, String age, String telephone, String cal) {
        this.id = id;
        this.number=number;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.telephone = telephone;
        this.cal = cal;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCal() {
        return cal;
    }
}
