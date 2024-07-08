package main.java.ru.clevertec.check.exception;

/**
 * При неверных входных данных (не
 * верно заполнены аргументы, ошибки
 * количества, отсутствия products)
 */

public class BadRequestException extends CustomException {
    public BadRequestException(String message) {
        super(message);
    }
}
