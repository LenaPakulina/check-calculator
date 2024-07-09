package main.java.ru.clevertec.check.utils.validator;

import main.java.ru.clevertec.check.exception.BadRequestException;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.model.Product;

import java.util.Map;

public class CheckValidator {
    public void checkProductsAmount(Map<Product, Integer> productCountMap) {
        if (productCountMap.isEmpty()) {
            throw new BadRequestException("Нет списка продуктов.");
        }
        StringBuilder errorMsg = new StringBuilder();
        for (Product product: productCountMap.keySet()) {
            if (product.getQuantityInStock() < productCountMap.get(product)) {
                errorMsg.append("Нет необходимого кол-ва товара \"%s\". Требуется: %d, имеется на складе: %d.%n."
                                .formatted(
                                        product.getDescription(),
                                        productCountMap.get(product),
                                        product.getQuantityInStock()
                                )
                );
            }
        }
        if (!errorMsg.isEmpty()) {
            throw new BadRequestException(errorMsg.toString());
        }
    }

    public void checkStartBalance(double startBalance) {
        if (startBalance < 10e-3) {
            throw new NotEnoughMoneyException("NOT ENOUGH MONEY");
        }
    }

    public void checkBalance(double balance, double finalPrice) {
        if ((balance - finalPrice) < 0.001) {
            throw new NotEnoughMoneyException("NOT ENOUGH MONEY");
        }
    }
}
