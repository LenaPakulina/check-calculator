package main.java.ru.clevertec.check.output;

import main.java.ru.clevertec.check.dto.CheckDTO;

public interface CheckConverterToString {
    public String toString(CheckDTO checkDTO);
}
