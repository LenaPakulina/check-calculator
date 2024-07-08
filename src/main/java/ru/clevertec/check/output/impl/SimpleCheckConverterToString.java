package main.java.ru.clevertec.check.output.impl;

import main.java.ru.clevertec.check.dto.CheckDTO;
import main.java.ru.clevertec.check.dto.ProductDTO;
import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.output.CheckConverterToString;

import java.time.format.DateTimeFormatter;

public class SimpleCheckConverterToString implements CheckConverterToString {
    @Override
    public String toString(CheckDTO checkDTO) {
        StringBuilder stringBuilder = new StringBuilder();

        addDateTimeInfo(stringBuilder, checkDTO);
        stringBuilder.append(System.lineSeparator());

        addProductDTOInfo(stringBuilder, checkDTO);
        stringBuilder.append(System.lineSeparator());

        if (checkDTO.getDiscountCard().isPresent()) {
            addDiscountCardInfo(stringBuilder, checkDTO.getDiscountCard().get());
            stringBuilder.append(System.lineSeparator());
        }

        addTotalPriceInfo(stringBuilder, checkDTO);
        return stringBuilder.toString();
    }

    private void addDateTimeInfo(StringBuilder stringBuilder, CheckDTO checkDTO) {
        stringBuilder.append("Date;Time");
        stringBuilder.append(System.lineSeparator());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy;HH:mm:ss");
        stringBuilder.append(formatter.format(checkDTO.getCreated()));
        stringBuilder.append(System.lineSeparator());
    }

    private void addProductDTOInfo(StringBuilder stringBuilder, CheckDTO checkDTO) {
        stringBuilder.append("QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL");
        stringBuilder.append(System.lineSeparator());
        for (ProductDTO dto : checkDTO.getProductsInfoList()) {
            stringBuilder.append("%d;".formatted(dto.getAmount()));
            stringBuilder.append("%s;".formatted(dto.getDescription()));
            stringBuilder.append("%.2f$;".formatted(dto.getPrice()));
            stringBuilder.append("%.2f$;".formatted(dto.getDiscount()));
            stringBuilder.append("%.2f$%n".formatted(dto.getTotalPrice()));
        }
    }

    private void addTotalPriceInfo(StringBuilder stringBuilder, CheckDTO checkDTO) {
        stringBuilder.append("TOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("%.2f$;%.2f$;%.2f$".formatted(
                checkDTO.getTotalPriceDTO().getTotalPrice(),
                checkDTO.getTotalPriceDTO().getTotalDiscount(),
                checkDTO.getTotalPriceDTO().getTotalPriceWithDiscount()
        ));
    }

    private void addDiscountCardInfo(StringBuilder stringBuilder, DiscountCard discountCard) {
        stringBuilder.append("DISCOUNT CARD;DISCOUNT PERCENTAGE");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("%d;%d%n".formatted(
                discountCard.getNumber(),
                discountCard.getDiscountAmount()
        ));
    }
}
