package main.java.ru.clevertec.check.dto;

public class ProductDTO {
    private int productId;
    private String description;
    private double price;
    private double discount;
    private double totalPrice;
    private int amount;

    private ProductDTO(Builder builder) {
        this.productId = builder.productId;
        this.description = builder.description;
        this.price = builder.price;
        this.discount = builder.discount;
        this.totalPrice = builder.totalPrice;
        this.amount = builder.amount;
    }

    public int getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public static class Builder {
        private int productId;
        private String description;
        private double price;
        private double discount;
        private double totalPrice;
        private int amount;

        public Builder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }
}