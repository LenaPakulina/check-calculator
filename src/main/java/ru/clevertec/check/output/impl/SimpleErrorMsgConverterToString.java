package main.java.ru.clevertec.check.output.impl;

import main.java.ru.clevertec.check.output.ErrorMsgConverterToString;

public class SimpleErrorMsgConverterToString implements ErrorMsgConverterToString {
    @Override
    public String toString(String msg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ERROR");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(msg);
        return stringBuilder.toString();
    }
}
