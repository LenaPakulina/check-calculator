package main.java.ru.clevertec.check.exception;

/**
 * При недостатке средств (баланс
 * меньше, чем сумма в чеке)
 */

public class NotEnoughMoneyException extends CustomException {
    public NotEnoughMoneyException() {
        super("NOT ENOUGH MONEY");
    }
}