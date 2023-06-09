package com.example.reflection.constant;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 6:46 PM

ProjectName: reflection*/

public enum SqlDataType {
    INTEGER("INT"),
    SMALL_INTEGER("SMALLINT"),
    BIG_INTEGER("BIGINT"),
    FLOAT("FLOAT"),
    DOUBLE("DOUBLE"),
    DATE("DATE"),
    TIME_STAMP("TIMESTAMP"),
    TEXT("TEXT");

    public String value;

    private SqlDataType(String value) {this.value = value;}
}
