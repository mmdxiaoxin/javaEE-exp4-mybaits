package com.example.exp4.models;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String press;
    private Date pressDate;
    private float price;
}
