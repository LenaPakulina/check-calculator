package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.utils.argparser.LaunchParams;

import java.util.Map;
import java.util.Optional;

public interface ProductService {
    public Optional<Product> findById(int id);

    public Map<Product, Integer> getProductEntityByOptions(LaunchParams options);
}
