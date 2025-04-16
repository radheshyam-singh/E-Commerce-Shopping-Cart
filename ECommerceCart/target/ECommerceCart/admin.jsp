<%@ page import="com.ecommerce.dao.ProductDAO, com.ecommerce.model.Product" %>
<%@ page import="java.util.*" %>
<%
    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.getAllProducts();
%>
<html>
<head><title>Admin Dashboard</title>
<link rel="stylesheet" href="css/addproduct.css">
</head>
<body>
<h2>All Products</h2>
<% for (Product p : products) { %>
    <p><%= p.getName() %> - ?<%= p.getPrice() %></p>
<% } %>
<a href="addProduct.jsp">Add New Product</a>
</body>
</html>
