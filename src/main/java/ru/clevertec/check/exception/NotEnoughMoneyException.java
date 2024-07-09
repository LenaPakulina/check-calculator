package main.java.ru.clevertec.check.exception;

/**
 * При недостатке средств (баланс
 * меньше, чем сумма в чеке)
 */

public class NotEnoughMoneyException extends CustomException {
    public NotEnoughMoneyException(String message) {
        super("INTERNAL SERVER ERROR%n%s".formatted(message));
    }

    public NotEnoughMoneyException() {
        super("INTERNAL SERVER ERROR");
    }
}