package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.model.DiscountCard;

import java.util.Optional;

public interface DiscountService {
    public Optional<DiscountCard> findByCardNum(int cardNum);
}
