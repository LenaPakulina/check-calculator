package main.java.ru.clevertec.check.exception;

/**
 * При любых ситуациях
 */

public class InternalServerException extends CustomException {
    public InternalServerException(String message) {
        super("INTERNAL SERVER ERROR%n%s".formatted(message));
    }

    public InternalServerException() {
        super("INTERNAL SERVER ERROR");
    }
}