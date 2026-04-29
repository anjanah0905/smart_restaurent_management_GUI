# Restaurant Management System

A Java-based GUI application for managing restaurant menu items and orders with MySQL database integration.

## Project Structure

```text
src/
|-- db/
|   `-- DBConnection.java          # Database connection manager
|-- dao/
|   `-- RestaurantDAO.java         # Data Access Object for CRUD operations
|-- model/
|   |-- MenuItem.java              # Menu item model
|   `-- Order.java                 # Order model
|-- ui/
|   |-- MainFrame.java             # Main application window
|   |-- AddItemForm.java           # Add menu item form
|   |-- ViewMenuForm.java          # View all menu items
|   |-- PlaceOrderForm.java        # Place new orders
|   `-- ViewOrdersForm.java        # View all orders
`-- Main.java                      # Application entry point
```

## Prerequisites

- Java Development Kit (JDK 8 or higher)
- MySQL Server
- MySQL JDBC Driver (`mysql-connector-j-9.6.0.jar`)

## Setup Instructions

### 1. Install MySQL
Download and install MySQL from [mysql.com](https://www.mysql.com/downloads/)

### 2. Create Database
Execute the `db.sql` file to create the database and tables.

Using MySQL Command Line:

```bash
mysql -u root -p < db.sql
```

Using MySQL Workbench:

1. Open MySQL Workbench
2. File -> Open SQL Script -> Select `db.sql`
3. Click Execute

You can verify the database was created with:

```sql
SHOW DATABASES;
```

Make sure `restaurant_db` appears in the results.

### 3. Update Database Credentials
Edit `src/db/DBConnection.java` and update your MySQL password:

```java
static final String USER = "root";
static final String PASS = "your_mysql_password";  // Change this to your password
```

Current connection settings:

- Host: `localhost`
- Port: `3306`
- Database: `restaurant_db`
- Username: `root`
- Password: your MySQL root password

### 4. Compile the Application
Navigate to the project root and run:

```powershell
javac -cp ".;mysql-connector-j-9.6.0.jar" src/Main.java src/db/DBConnection.java src/model/MenuItem.java src/model/Order.java src/dao/RestaurantDAO.java src/ui/MainFrame.java src/ui/AddItemForm.java src/ui/ViewMenuForm.java src/ui/PlaceOrderForm.java src/ui/ViewOrdersForm.java
```

### 5. Run the Application
From the project root, run:

```powershell
java -cp "src;.\mysql-connector-j-9.6.0.jar" Main
```

### 6. Alternative: Run from the `src` Folder
If you prefer to work inside the `src` folder:

```powershell
cd src
javac -cp ".;..\mysql-connector-j-9.6.0.jar" Main.java db/DBConnection.java model/MenuItem.java model/Order.java dao/RestaurantDAO.java ui/MainFrame.java ui/AddItemForm.java ui/ViewMenuForm.java ui/PlaceOrderForm.java ui/ViewOrdersForm.java
java -cp ".;..\mysql-connector-j-9.6.0.jar" Main
```

## Features

### Main Menu Operations
- File -> Exit: Close the application
- Operations -> Add Menu Item: Add new food and drink items
- Operations -> View Menu: Display all menu items in a table
- Operations -> Place Order: Create new orders for items
- Operations -> View Orders: View all placed orders

## Database Tables

### `menu` table
- `item_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `item_name` (VARCHAR 100)
- `category` (VARCHAR 50) - `Food` or `Drink`
- `price` (INT)

### `orders` table
- `order_id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `item_id` (INT, FOREIGN KEY)
- `quantity` (INT)
- `total` (INT)
- `order_date` (DATE)

## Sample Data
The `db.sql` file inserts 5 sample menu items:

- Veg Burger (Food) - Rs.120
- Chicken Biryani (Food) - Rs.220
- French Fries (Food) - Rs.90
- Coke (Drink) - Rs.40
- Beer (Drink) - Rs.150

## Troubleshooting

### Error: `Access denied for user 'root'@'localhost'`
Update the password in `src/db/DBConnection.java` to match your MySQL root password.

### Error: `Unknown database 'restaurant_db'`
Run `db.sql` before launching the app. The application expects this database name exactly:

```java
jdbc:mysql://localhost:3306/restaurant_db
```

### Error: `Could not find or load main class Main`
This means Java is not looking in the `src` folder for compiled classes. Run the app with:

```powershell
java -cp "src;.\mysql-connector-j-9.6.0.jar" Main
```

### Error: `ClassNotFoundException: com.mysql.cj.jdbc.Driver`
This means the MySQL JDBC driver jar is not on the runtime classpath. Make sure `mysql-connector-j-9.6.0.jar` is in the project root and run:

```powershell
java -cp "src;.\mysql-connector-j-9.6.0.jar" Main
```

### Window does not appear
Check whether the window opened off-screen. Use Alt+Tab or check the taskbar.

## Usage Example

1. Launch the application:

```powershell
java -cp "src;.\mysql-connector-j-9.6.0.jar" Main
```

2. Add a Menu Item:
- Click Operations -> Add Menu Item
- Enter Item Name, select Category, enter Price
- Click Submit

3. View Menu:
- Click Operations -> View Menu
- See all items in table format

4. Place an Order:
- Click Operations -> Place Order
- Select an item from the dropdown
- Enter quantity
- Click Place Order

5. View Orders:
- Click Operations -> View Orders
- See all orders with details

## Architecture

The application follows the MVC pattern:

- Model: `MenuItem.java`, `Order.java`
- View: UI forms in `ui/`
- Controller: `RestaurantDAO.java`

## Technologies Used

- Java Swing
- MySQL
- JDBC
- MVC Architecture

## Notes

- Ensure MySQL is running before launching the application
- The database connection is established on first use
- All dates are stored in `YYYY-MM-DD` format
- Orders automatically use the current date

## Author
Created for Smart Restaurant Management System

## License
This project is provided as-is for educational purposes.
