package main.java.ru.clevertec.check.storage;


import main.java.ru.clevertec.check.model.Product;

import java.util.Optional;

public interface ProductStorage {
    public Optional<Product> findById(int id);
}
