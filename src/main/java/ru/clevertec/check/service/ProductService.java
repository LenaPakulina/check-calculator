package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.ProductDTO;
import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.utils.argparser.LaunchOptions;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    public Optional<Product> findById(int id);

    public Map<Product, Integer> getProductEntityByOptions(LaunchOptions options);
}
