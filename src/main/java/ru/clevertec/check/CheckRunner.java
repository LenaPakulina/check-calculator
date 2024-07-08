package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.output.CheckConverterToString;
import main.java.ru.clevertec.check.output.impl.SimpleCheckConverterToString;
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
        try {
            LaunchOptions options = ArgParser.parse(args);
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

            CheckConverterToString print = new SimpleCheckConverterToString();
            System.out.println(print.toString(checkService.createCheck(options)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}