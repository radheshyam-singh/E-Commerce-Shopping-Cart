<%@ page import="com.ecommerce.dao.CartDAO, com.ecommerce.model.CartItem" %>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%
    com.ecommerce.model.User user = (com.ecommerce.model.User) session.getAttribute("user");
    CartDAO dao = new CartDAO();
    List<CartItem> cart = dao.getCartItems(user.getId());
%>
<html>
<head><title>Cart</title>
<link rel="stylesheet" href="css/cart.css">
</head>
<body>
<h2>Your Cart</h2>
<% for (CartItem item : cart) { %>
    <p><%= item.getProduct().getName() %> x <%= item.getQuantity() %> = ?<%= item.getProduct().getPrice() * item.getQuantity() %></p>
<% } %>
<a href="ordersuccess.jsp">Checkout</a>
</body>
</html>
