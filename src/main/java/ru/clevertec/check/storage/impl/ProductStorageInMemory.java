package main.java.ru.clevertec.check.storage.impl;

import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.storage.ProductStorage;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductStorageInMemory implements ProductStorage {
    private final Map<Integer, Product> products;

    public ProductStorageInMemory(List<Product> products) {
        this.products = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.ofNullable(products.get(id));
    }
}
