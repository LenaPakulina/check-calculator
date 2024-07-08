package main.java.ru.clevertec.check.utils.filereader.impl;

import main.java.ru.clevertec.check.exception.InternalServerException;
import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.utils.filereader.DiscountFileReader;
import main.java.ru.clevertec.check.utils.filereader.ProductFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDiscountFileReader implements DiscountFileReader {
    @Override
    public List<DiscountCard> parseFile(String filePath) {
        List<DiscountCard> cards = new ArrayList<>();

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
                    int number = Integer.parseInt(values[1]);
                    short discountAmount = Short.parseShort(values[2]);
                    DiscountCard card = new DiscountCard(id, number, discountAmount);
                    cards.add(card);
                }
            }
        } catch (IOException e) {
            throw new InternalServerException("Не удалось прочитать файл дисконтных карт. Файл: %s".formatted(filePath));
        }

        return cards;
    }
}
