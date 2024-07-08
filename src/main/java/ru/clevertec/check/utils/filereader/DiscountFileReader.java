package main.java.ru.clevertec.check.utils.filereader;

import main.java.ru.clevertec.check.model.DiscountCard;

import java.util.List;

public interface DiscountFileReader {
    public List<DiscountCard> parseFile(String filePath);
}
