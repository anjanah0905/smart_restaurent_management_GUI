package model;

public class MenuItem {
    private int itemId;
    private String itemName;
    private String category;
    private int price;

    public MenuItem(int itemId, String itemName, String category, int price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public MenuItem(String itemName, String category, int price) {
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
