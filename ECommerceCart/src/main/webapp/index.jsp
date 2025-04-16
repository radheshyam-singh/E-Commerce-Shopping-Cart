<%@ page import="com.ecommerce.dao.ProductDAO, com.ecommerce.model.Product" %>
<%@ page import="java.util.*" %>
<%@ page session="false" %>
<%
    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.getAllProducts();
%>
<html>
<head><title>Home</title></head>
<head>
    <title>My E-Commerce App</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Products</h2>
<% for (Product p : products) { %>
    <form action="addToCart" method="post">
        <p><%= p.getName() %> - ?<%= p.getPrice() %></p>
        <input type="hidden" name="productId" value="<%= p.getId() %>">
        Quantity: <input type="number" name="quantity" value="1">
        <button type="submit">Add to Cart</button>
    </form>
<% } %>
</body>
</html>
