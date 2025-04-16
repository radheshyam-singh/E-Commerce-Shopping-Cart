package com.ecommerce.servlets;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product p = new Product();
        p.setName(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setDescription(request.getParameter("description"));

        ProductDAO dao = new ProductDAO();
        dao.addProduct(p);

        response.sendRedirect("admin.jsp");
    }
}
