package model;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int itemId;
    private int quantity;
    private int total;
    private LocalDate orderDate;

    public Order(int orderId, int itemId, int quantity, int total, LocalDate orderDate) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.total = total;
        this.orderDate = orderDate;
    }

    public Order(int itemId, int quantity, int total) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.total = total;
        this.orderDate = LocalDate.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orderDate=" + orderDate +
                '}';
    }
}
