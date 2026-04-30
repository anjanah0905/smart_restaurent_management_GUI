package ui;

import dao.RestaurantDAO;
import java.awt.*;
import javax.swing.*;
import model.MenuItem;

public class AddItemForm extends JFrame {
    private JTextField itemNameField, priceField;
    private JComboBox<String> categoryCombo;
    private JButton submitButton, cancelButton;
    private RestaurantDAO dao;

    public AddItemForm() {
        dao = new RestaurantDAO();
        setTitle("Add Menu Item");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField();
        
        JLabel categoryLabel = new JLabel("Category:");
        categoryCombo = new JComboBox<>(new String[]{"Food", "Drink"});
        
        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField();
        
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        submitButton.addActionListener(e -> addItem());
        cancelButton.addActionListener(e -> dispose());

        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(categoryLabel);
        panel.add(categoryCombo);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(submitButton);
        panel.add(cancelButton);

        add(panel);
    }

    private void addItem() {
        try {
            String itemName = itemNameField.getText();
            String category = (String) categoryCombo.getSelectedItem();
            int price = Integer.parseInt(priceField.getText());

            if (itemName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter item name");
                return;
            }

            MenuItem item = new MenuItem(itemName, category, price);
            dao.addMenuItem(item);
            JOptionPane.showMessageDialog(this, "Item added successfully!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid price");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
