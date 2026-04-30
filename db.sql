CREATE DATABASE restaurant_db;
USE restaurant_db;

CREATE TABLE menu (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100),
    category VARCHAR(50),
    price INT
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    item_id INT,
    quantity INT,
    total INT,
    order_date DATE,
    FOREIGN KEY (item_id) REFERENCES menu(item_id)
);

INSERT INTO menu(item_name, category, price) VALUES
('Veg Burger', 'Food', 120),
('Chicken Biryani', 'Food', 220),
('French Fries', 'Food', 90),
('Coke', 'Drink', 40),
('Beer', 'Drink', 150);
