package main.java.ru.clevertec.check.utils.argparser;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

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

    /** Относительный путь к файлу с продуктами */
    private Optional<String> pathToFile = Optional.empty();

    /** Относительный путь к файлу результата */
    private Optional<String> saveToFile = Optional.empty();

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

    public Optional<String> getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(Optional<String> pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Optional<String> getSaveToFile() {
        return saveToFile;
    }

    public void setSaveToFile(Optional<String> saveToFile) {
        this.saveToFile = saveToFile;
    }
}
