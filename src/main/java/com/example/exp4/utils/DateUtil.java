package com.example.exp4.utils;


import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/*
 * 日期转换工具类
 * */
public class DateUtil {
    public static java.util.Date strToUtilDate(String strDate) {

        try {
            if (strDate != null) {
                if (Pattern.matches("\\d{4}/\\d{2}/\\d{2}", strDate)) {
                    return new SimpleDateFormat("yyyy/MM/dd").parse(strDate);
                }
                if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", strDate)) {
                    return new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public static java.sql.Date utilToSqlDate(java.util.Date date) {

        if (date != null) {
            return new java.sql.Date(date.getTime());
        }
        return null;

    }
}

