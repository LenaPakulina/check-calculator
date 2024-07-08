package main.java.ru.clevertec.check.storage;

import main.java.ru.clevertec.check.model.DiscountCard;

import java.util.Optional;

public interface DiscountCardStorage {
    public Optional<DiscountCard> findByCardNum(int cardNum);
}
