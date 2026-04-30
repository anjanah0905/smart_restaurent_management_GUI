package ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu, operationMenu;
    private JMenuItem exitItem, addItemItem, viewMenuItem, placeOrderItem, viewOrdersItem;

    public MainFrame() {
        setTitle("Restaurant Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        createMenuBar();
        System.out.println("✓ MainFrame created");
        setVisible(true);
        System.out.println("✓ MainFrame visible on screen");
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        
        // File Menu
        fileMenu = new JMenu("File");
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        // Operation Menu
        operationMenu = new JMenu("Operations");
        addItemItem = new JMenuItem("Add Menu Item");
        viewMenuItem = new JMenuItem("View Menu");
        placeOrderItem = new JMenuItem("Place Order");
        viewOrdersItem = new JMenuItem("View Orders");
        
        addItemItem.addActionListener(e -> new AddItemForm());
        viewMenuItem.addActionListener(e -> new ViewMenuForm());
        placeOrderItem.addActionListener(e -> new PlaceOrderForm());
        viewOrdersItem.addActionListener(e -> new ViewOrdersForm());
        
        operationMenu.add(addItemItem);
        operationMenu.add(viewMenuItem);
        operationMenu.add(placeOrderItem);
        operationMenu.add(viewOrdersItem);
        
        menuBar.add(fileMenu);
        menuBar.add(operationMenu);
        setJMenuBar(menuBar);
    }
}
