package main.java.ru.clevertec.check.exception;

/**
 * При любых ситуациях
 */

public class InternalServerException extends CustomException {
    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}