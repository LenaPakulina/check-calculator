package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.service.DiscountService;
import main.java.ru.clevertec.check.storage.DiscountCardStorage;

import java.util.Optional;

public class DiscountServiceCsv implements DiscountService {
    private final DiscountCardStorage discountCardStorage;

    public DiscountServiceCsv(DiscountCardStorage storage) {
        this.discountCardStorage = storage;
    }

    @Override
    public Optional<DiscountCard> findByCardNum(int cardNum) {
        Optional<DiscountCard> card = discountCardStorage.findByCardNum(cardNum);
        if (card.isPresent()) {
            return card;
        }
        if (cardNum > 0) {
            return Optional.of(new DiscountCard(cardNum, cardNum, (short) 2));
        }
        return Optional.empty();
    }
}
