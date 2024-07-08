package main.java.ru.clevertec.check.dto;

public class TotalPriceDTO {
    private double totalPrice;
    private double totalDiscount;
    private double totalPriceWithDiscount;

    private TotalPriceDTO(Builder builder) {
        this.totalPrice = builder.totalPrice;
        this.totalDiscount = builder.totalDiscount;
        this.totalPriceWithDiscount = builder.totalPriceWithDiscount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPriceWithDiscount() {
        return totalPriceWithDiscount;
    }

    public static class Builder {
        private double totalPrice;
        private double totalDiscount;
        private double totalPriceWithDiscount;

        // Методы установки значений полей
        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setTotalDiscount(double totalDiscount) {
            this.totalDiscount = totalDiscount;
            return this;
        }

        public Builder setTotalPriceWithDiscount(double totalPriceWithDiscount) {
            this.totalPriceWithDiscount = totalPriceWithDiscount;
            return this;
        }

        public TotalPriceDTO build() {
            return new TotalPriceDTO(this);
        }
    }
}
