package dao;

import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.MenuItem;
import model.Order;

public class RestaurantDAO {

    public void addMenuItem(MenuItem item) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO menu(item_name, category, price) VALUES(?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, item.getItemName());
        ps.setString(2, item.getCategory());
        ps.setInt(3, item.getPrice());
        ps.executeUpdate();
        ps.close();
    }

    public List<MenuItem> getAllMenuItems() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM menu";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<MenuItem> items = new ArrayList<>();
        
        while (rs.next()) {
            MenuItem item = new MenuItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("price")
            );
            items.add(item);
        }
        
        rs.close();
        stmt.close();
        return items;
    }

    public MenuItem getMenuItemById(int itemId) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM menu WHERE item_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, itemId);
        ResultSet rs = ps.executeQuery();
        
        MenuItem item = null;
        if (rs.next()) {
            item = new MenuItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getString("category"),
                rs.getInt("price")
            );
        }
        
        rs.close();
        ps.close();
        return item;
    }

    public void placeOrder(Order order) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO orders(item_id, quantity, total, order_date) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, order.getItemId());
        ps.setInt(2, order.getQuantity());
        ps.setInt(3, order.getTotal());
        ps.setDate(4, Date.valueOf(order.getOrderDate()));
        ps.executeUpdate();
        ps.close();
    }

    public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM orders";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Order> orders = new ArrayList<>();
        
        while (rs.next()) {
            Order order = new Order(
                rs.getInt("order_id"),
                rs.getInt("item_id"),
                rs.getInt("quantity"),
                rs.getInt("total"),
                rs.getDate("order_date").toLocalDate()
            );
            orders.add(order);
        }
        
        rs.close();
        stmt.close();
        return orders;
    }

    public List<Order> getOrdersByItemId(int itemId) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM orders WHERE item_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, itemId);
        ResultSet rs = ps.executeQuery();
        List<Order> orders = new ArrayList<>();
        
        while (rs.next()) {
            Order order = new Order(
                rs.getInt("order_id"),
                rs.getInt("item_id"),
                rs.getInt("quantity"),
                rs.getInt("total"),
                rs.getDate("order_date").toLocalDate()
            );
            orders.add(order);
        }
        
        rs.close();
        ps.close();
        return orders;
    }
}
