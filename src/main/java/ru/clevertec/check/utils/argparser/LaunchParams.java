package main.java.ru.clevertec.check.utils.argparser;

import java.util.LinkedHashMap;
import java.util.Map;

public class LaunchParams {
    /** Название и номер дисконтной карты */
    private int discountCardNum;

    /** Баланс на дебетовой карте */
    private double balanceDebitCard;

    /**
     * Словарь хранения id продуктов и их кол-во.
     * Хранение предполагает общую сумму товаров.
     * К примеру: 1-3 2-5 1-1 в нашем поле будет: 1-4 2-5
     * (порядок гарантирован = LinkedHashMap)
     */
    private Map<Integer, Integer> productIdAndCount = new LinkedHashMap<>();

    public LaunchParams() {
    }

    public int getDiscountCardNum() {
        return discountCardNum;
    }

    public double getBalanceDebitCard() {
        return balanceDebitCard;
    }

    public Map<Integer, Integer> getProductIdAndCount() {
        return productIdAndCount;
    }

    public void setDiscountCardNum(int discountCardNum) {
        this.discountCardNum = discountCardNum;
    }

    public void setBalanceDebitCard(double balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }

    public void setProductIdAndCount(Map<Integer, Integer> productIdAndCount) {
        this.productIdAndCount = productIdAndCount;
    }
}
