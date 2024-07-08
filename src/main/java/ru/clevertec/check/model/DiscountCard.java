package main.java.ru.clevertec.check.model;

import java.util.Objects;

public class DiscountCard {
    /** Идентификатор дисконтной карты */
    private int id;

    /** Номер карты */
    private int number;

    /** Предоставляемая скидка */
    private short discountAmount;

    public DiscountCard() {
    }

    public DiscountCard(int id, int number, short discountAmount) {
        this.id = id;
        this.number = number;
        this.discountAmount = discountAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public short getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(short discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountCard that = (DiscountCard) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
