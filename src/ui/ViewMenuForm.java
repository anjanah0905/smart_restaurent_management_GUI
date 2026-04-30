package ui;

import dao.RestaurantDAO;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.MenuItem;

public class ViewMenuForm extends JFrame {
    private JTable table;
    private RestaurantDAO dao;

    public ViewMenuForm() {
        dao = new RestaurantDAO();
        setTitle("View Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        initializeComponents();
        loadMenuItems();
        setVisible(true);
    }

    private void initializeComponents() {
        String[] columnNames = {"Item ID", "Item Name", "Category", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void loadMenuItems() {
        try {
            List<MenuItem> items = dao.getAllMenuItems();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            
            for (MenuItem item : items) {
                Object[] row = {
                    item.getItemId(),
                    item.getItemName(),
                    item.getCategory(),
                    item.getPrice()
                };
                model.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading menu: " + ex.getMessage());
        }
    }
}
