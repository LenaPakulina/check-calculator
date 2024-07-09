package main.java.ru.clevertec.check.exception;

/**
 * При неверных входных данных (не
 * верно заполнены аргументы, ошибки
 * количества, отсутствия products)
 */

public class BadRequestException extends CustomException {
    public BadRequestException(String message) {
        super("BAD REQUEST%n%s".formatted(message));
    }

    public BadRequestException() {
        super("BAD REQUEST");
    }
}
