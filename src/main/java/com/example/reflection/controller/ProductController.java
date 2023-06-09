package com.example.reflection.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/7/2023
Time: 6:40 PM

ProjectName: reflection*/

import com.example.reflection.dto.ProductDto;
import com.example.reflection.entity.Product;
import com.example.reflection.repository.impl.ProductRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name= "productservlet", value= "/product")
public class ProductController extends HttpServlet {
    private static Logger logger = LogManager.getLogger(ProductController.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        logger.info("Process = get request to Product Controller");
        RequestDispatcher view = request.getRequestDispatcher("product-list.jsp");

        ProductRepositoryImpl productRepo = new ProductRepositoryImpl();

        List<Product> productList = productRepo.findall();
        request.setAttribute("product", productList);

        request.setAttribute("num", 2);



        view.forward(request, response);
    }
}
