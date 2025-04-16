package com.ecommerce.dao;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.utils.DBConnection;

import java.sql.*;
import java.util.*;

public class CartDAO {

    ProductDAO productDAO = new ProductDAO();

    public boolean addToCart(int userId, int productId, int quantity) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cart(user_id, product_id, quantity) VALUES (?, ?, ?)");
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<CartItem> getCartItems(int userId) {
        List<CartItem> items = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cart WHERE user_id=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                Product p = productDAO.getProductById(productId);
                CartItem item = new CartItem(
                    rs.getInt("id"),
                    userId,
                    p,
                    rs.getInt("quantity")
                );
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public void clearCart(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM cart WHERE user_id=?");
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
