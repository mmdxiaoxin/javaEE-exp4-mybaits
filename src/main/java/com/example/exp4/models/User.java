package com.example.exp4.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String sex;
    private String nickname;
    private int usertype;
}
