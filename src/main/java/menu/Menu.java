package menu;

public class Menu {
    private String name;
    private double price;
    private int quantity;
    private double sales = 0;

    public Menu(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Menu(String name, double price, int quantity, double sales) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSales() {
        return sales;
    }
}
