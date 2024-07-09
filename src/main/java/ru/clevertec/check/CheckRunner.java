package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.output.CheckConverterToString;
import main.java.ru.clevertec.check.output.ErrorMsgConverterToString;
import main.java.ru.clevertec.check.output.PrintToFile;
import main.java.ru.clevertec.check.output.impl.CheckConverterToCsvString;
import main.java.ru.clevertec.check.output.impl.SimpleErrorMsgConverterToString;
import main.java.ru.clevertec.check.output.impl.SimplePrintToFile;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.service.DiscountService;
import main.java.ru.clevertec.check.service.ProductService;
import main.java.ru.clevertec.check.service.impl.CheckServiceImpl;
import main.java.ru.clevertec.check.service.impl.DiscountServiceCsv;
import main.java.ru.clevertec.check.service.impl.ProductServiceCsv;
import main.java.ru.clevertec.check.storage.DiscountCardStorage;
import main.java.ru.clevertec.check.storage.ProductStorage;
import main.java.ru.clevertec.check.storage.impl.DiscountCardStorageInMemory;
import main.java.ru.clevertec.check.storage.impl.ProductStorageInMemory;
import main.java.ru.clevertec.check.utils.argparser.ArgParser;
import main.java.ru.clevertec.check.utils.argparser.LaunchOptions;
import main.java.ru.clevertec.check.utils.filereader.impl.CsvDiscountFileReader;
import main.java.ru.clevertec.check.utils.filereader.impl.CsvProductFileReader;

public class CheckRunner {
    public static void main(String[] args) {
        PrintToFile printer = new SimplePrintToFile();
        try {
            LaunchOptions options = ArgParser.parse(args);
            CheckService checkService = createCheckService();
            CheckConverterToString print = new CheckConverterToCsvString();
            String str = print.toString(checkService.createCheck(options));
            System.out.println(str);
            printer.print("./result.csv", str);
        } catch (Exception e) {
            ErrorMsgConverterToString print = new SimpleErrorMsgConverterToString();
            String str = print.toString(e.getMessage());
            System.out.println(str);
            printer.print("./result.csv", str);
        }
    }

    private static CheckService createCheckService() throws RuntimeException {
        CsvDiscountFileReader discountFileReader = new CsvDiscountFileReader();
        CsvProductFileReader productFileReader = new CsvProductFileReader();
        ProductStorage productStorage = new ProductStorageInMemory(
                productFileReader.parseFile("./src/main/resources/products.csv")
        );
        ProductService productService = new ProductServiceCsv(productStorage);
        DiscountCardStorage discountCardStorage = new DiscountCardStorageInMemory(
                discountFileReader.parseFile("./src/main/resources/discountCards.csv")
        );
        DiscountService discountService = new DiscountServiceCsv(discountCardStorage);
        CheckService checkService = new CheckServiceImpl(productService, discountService);
        return checkService;
    }
}