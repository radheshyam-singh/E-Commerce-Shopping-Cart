package com.ecommerce.servlets;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        CartDAO dao = new CartDAO();
        dao.addToCart(user.getId(), productId, quantity);

        response.sendRedirect("cart.jsp");
    }
}
