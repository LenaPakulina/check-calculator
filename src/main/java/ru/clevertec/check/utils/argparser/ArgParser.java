package main.java.ru.clevertec.check.utils.argparser;

import java.util.Map;
import java.util.Optional;

public class ArgParser {
    public static LaunchParams parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        LaunchParams launchParams = new LaunchParams();
        for (String arg : args) {
            if (arg.contains("=")) {
                parseCommon(arg, launchParams);
            } else if (arg.contains("-")) {
                parseElement(arg, launchParams);
            }
        }
        return launchParams;
    }

    private static void parseCommon(String param, LaunchParams launchParams) {
        String key = param.substring(0, param.indexOf("="));
        String value = param.substring(param.indexOf("=") + 1);
        if ("discountCard".equals(key)) {
            launchParams.setDiscountCardNum(Integer.parseInt(value));
        } else if ("balanceDebitCard".equals(key)) {
            launchParams.setBalanceDebitCard(Double.parseDouble(value));
        }  else if ("pathToFile".equals(key)) {
            launchParams.setPathToFile(Optional.of(value));
        } else if ("saveToFile".equals(key)) {
            launchParams.setSaveToFile(Optional.of(value));
        }
    }

    private static void parseElement(String param, LaunchParams launchParams) {
        Integer key = Integer.valueOf(param.substring(0, param.indexOf("-")));
        Integer value = Integer.valueOf(param.substring(param.indexOf("-") + 1));
        Map<Integer, Integer> currentValue = launchParams.getProductIdAndCount();
        if (currentValue.containsKey(key)) {
            currentValue.put(key, value + currentValue.get(key));
        } else {
            currentValue.put(key, value);
        }
    }
}
