package main.java.ru.clevertec.check.utils.argparser;

import main.java.ru.clevertec.check.exception.InternalServerException;

import java.util.Map;

public class ArgParser {
    public static LaunchOptions parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        LaunchOptions launchOptions = new LaunchOptions();
        for (String arg : args) {
            if (arg.contains("=")) {
                parseCommon(arg, launchOptions);
            } else if (arg.contains("-")) {
                parseElement(arg, launchOptions);
            }
        }
        return launchOptions;
    }

    private static void parseCommon(String param, LaunchOptions launchOptions) {
        String key = param.substring(0, param.indexOf("="));
        String value = param.substring(param.indexOf("=") + 1);
        if ("discountCard".equals(key)) {
            launchOptions.setDiscountCardNum(Integer.parseInt(value));
        } else if ("balanceDebitCard".equals(key)) {
            launchOptions.setBalanceDebitCard(Double.parseDouble(value));
        }
    }

    private static void parseElement(String param, LaunchOptions launchOptions) {
        Integer key = Integer.valueOf(param.substring(0, param.indexOf("-")));
        Integer value = Integer.valueOf(param.substring(param.indexOf("-") + 1));
        Map<Integer, Integer> currentValue = launchOptions.getProductIdAndCount();
        if (currentValue.containsKey(key)) {
            currentValue.put(key, value + currentValue.get(key));
        } else {
            currentValue.put(key, value);
        }
    }
}
