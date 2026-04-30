package ui;

import dao.RestaurantDAO;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.MenuItem;
import model.Order;

public class PlaceOrderForm extends JFrame {
    private JComboBox<String> itemCombo;
    private JTextField quantityField;
    private JButton placeOrderButton, cancelButton;
    private RestaurantDAO dao;
    private List<MenuItem> items;

    public PlaceOrderForm() {
        dao = new RestaurantDAO();
        setTitle("Place Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        initializeComponents();
        loadMenuItems();
        setVisible(true);
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel itemLabel = new JLabel("Select Item:");
        itemCombo = new JComboBox<>();
        
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();
        
        placeOrderButton = new JButton("Place Order");
        cancelButton = new JButton("Cancel");

        placeOrderButton.addActionListener(e -> placeOrder());
        cancelButton.addActionListener(e -> dispose());

        panel.add(itemLabel);
        panel.add(itemCombo);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(placeOrderButton);
        panel.add(cancelButton);

        add(panel);
    }

    private void loadMenuItems() {
        try {
            items = dao.getAllMenuItems();
            for (MenuItem item : items) {
                itemCombo.addItem(item.getItemId() + " - " + item.getItemName() + " (Rs." + item.getPrice() + ")");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading items: " + ex.getMessage());
        }
    }

    private void placeOrder() {
        try {
            int selectedIndex = itemCombo.getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= items.size()) {
                JOptionPane.showMessageDialog(this, "Please select an item");
                return;
            }

            MenuItem selectedItem = items.get(selectedIndex);
            int quantity = Integer.parseInt(quantityField.getText());
            int total = selectedItem.getPrice() * quantity;

            Order order = new Order(selectedItem.getItemId(), quantity, total);
            dao.placeOrder(order);
            
            JOptionPane.showMessageDialog(this, "Order placed successfully!\nTotal: Rs." + total);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
