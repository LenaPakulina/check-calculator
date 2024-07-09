package main.java.ru.clevertec.check.utils.filereader;

import main.java.ru.clevertec.check.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductFileReader {
    public List<Product> parseFile(Optional<String> filePath);
}
