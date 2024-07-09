package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.exception.BadRequestException;
import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.service.ProductService;
import main.java.ru.clevertec.check.storage.ProductStorage;
import main.java.ru.clevertec.check.utils.argparser.LaunchParams;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceCsv implements ProductService {
    private final ProductStorage productStorage;

    public ProductServiceCsv(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    @Override
    public Optional<Product> findById(int id) {
        return productStorage.findById(id);
    }

    @Override
    public Map<Product, Integer> getProductEntityByOptions(LaunchParams options) {
        return options.getProductIdAndCount()
                .keySet()
                .stream()
                .collect(Collectors.toMap(
                        prodId -> productStorage.findById(prodId).orElseThrow(
                                () -> new BadRequestException("Не удалось найти продукт с id = %d".formatted(prodId))
                        ),
                        options.getProductIdAndCount()::get
                ));
    }
}
