package com.ecommerce.servlets;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        UserDAO dao = new UserDAO();
        if (dao.register(user)) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
