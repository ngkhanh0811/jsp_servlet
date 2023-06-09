package com.example.reflection.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/9/2023
Time: 9:03 PM

ProjectName: reflection*/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "productdetails", value= "/details")
public class ProductEditItem {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("details.jsp");
    }
}
