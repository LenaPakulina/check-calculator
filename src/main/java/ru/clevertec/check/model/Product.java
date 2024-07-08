package main.java.ru.clevertec.check.model;

import java.util.Objects;

public class Product {
    /** Идентификатор продукта */
    private int id;

    /** Описание продукта */
    private String description;

    /** Цена продукта */
    private double price;

    /** Кол-во товаров на складе */
    private int quantityInStock;

    /** Продукт может продаваться по оптовой цене? */
    private boolean isWholesale;

    public Product() {
    }

    public Product(int id, String description, double price, int quantityInStock, boolean isWholesale) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.isWholesale = isWholesale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public boolean isWholesale() {
        return isWholesale;
    }

    public void setWholesale(boolean wholesale) {
        isWholesale = wholesale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
