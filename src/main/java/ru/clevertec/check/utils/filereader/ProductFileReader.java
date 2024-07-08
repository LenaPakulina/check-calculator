package main.java.ru.clevertec.check.utils.filereader;

import main.java.ru.clevertec.check.model.Product;

import java.util.List;

public interface ProductFileReader {
    public List<Product> parseFile(String filePath);
}
