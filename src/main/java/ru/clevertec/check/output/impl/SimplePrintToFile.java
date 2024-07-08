package main.java.ru.clevertec.check.output.impl;

import main.java.ru.clevertec.check.exception.InternalServerException;
import main.java.ru.clevertec.check.output.PrintToFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimplePrintToFile implements PrintToFile {
    @Override
    public void print(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new InternalServerException("INTERNAL SERVER ERROR");
        }
    }
}
