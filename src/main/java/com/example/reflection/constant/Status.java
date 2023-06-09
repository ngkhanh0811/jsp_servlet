package com.example.reflection.constant;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 8:29 PM

ProjectName: reflection*/

public enum Status {
    ACTIVE(1),
        INACTIVE(0);
    public int value;
    private Status(int value) {this.value = value;}
}
