package main.java.ru.clevertec.check.utils.filereader.impl;

import main.java.ru.clevertec.check.exception.InternalServerException;
import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.utils.filereader.ProductFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvProductFileReader implements ProductFileReader {
    @Override
    public List<Product> parseFile(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    // Пропускаем первую строку с заголовками
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(";");
                if (values.length != 0 && !values[0].isEmpty()) {
                    int id = Integer.parseInt(values[0]);
                    String description = values[1];
                    double price = Double.parseDouble(values[2]);
                    int quantityInStock = Integer.parseInt(values[3]);
                    boolean isWholesale = Boolean.parseBoolean(values[4]);

                    Product product = new Product(id, description, price, quantityInStock, isWholesale);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            throw new InternalServerException("Не удалось прочитать файл продуктов. Файл: %s".formatted(filePath));
        }

        return products;
    }
}
