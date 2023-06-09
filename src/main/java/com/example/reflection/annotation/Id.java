package com.example.reflection.annotation;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 6:52 PM

ProjectName: reflection*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {
    String name();
}
