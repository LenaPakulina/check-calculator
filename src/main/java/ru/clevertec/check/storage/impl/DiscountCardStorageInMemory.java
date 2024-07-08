package main.java.ru.clevertec.check.storage.impl;

import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.storage.DiscountCardStorage;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiscountCardStorageInMemory implements DiscountCardStorage {
    private Map<Integer, DiscountCard> discountCards;

    public DiscountCardStorageInMemory(List<DiscountCard> discountCards) {
        this.discountCards = discountCards.stream()
                .collect(Collectors.toMap(DiscountCard::getNumber, Function.identity()));
    }

    @Override
    public Optional<DiscountCard> findByCardNum(int cardNum) {
        return Optional.ofNullable(discountCards.get(cardNum));
    }
}
