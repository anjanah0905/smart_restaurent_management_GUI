package ui;

import dao.RestaurantDAO;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Order;

public class ViewOrdersForm extends JFrame {
    private JTable table;
    private RestaurantDAO dao;

    public ViewOrdersForm() {
        dao = new RestaurantDAO();
        setTitle("View Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        initializeComponents();
        loadOrders();
        setVisible(true);
    }

    private void initializeComponents() {
        String[] columnNames = {"Order ID", "Item ID", "Quantity", "Total", "Order Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void loadOrders() {
        try {
            List<Order> orders = dao.getAllOrders();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            
            for (Order order : orders) {
                Object[] row = {
                    order.getOrderId(),
                    order.getItemId(),
                    order.getQuantity(),
                    order.getTotal(),
                    order.getOrderDate()
                };
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading orders: " + ex.getMessage());
        }
    }
}
