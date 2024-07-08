package main.java.ru.clevertec.check.service.impl;

import main.java.ru.clevertec.check.dto.CheckDTO;
import main.java.ru.clevertec.check.dto.ProductDTO;
import main.java.ru.clevertec.check.dto.TotalPriceDTO;
import main.java.ru.clevertec.check.model.DiscountCard;
import main.java.ru.clevertec.check.model.Product;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.service.DiscountService;
import main.java.ru.clevertec.check.service.ProductService;
import main.java.ru.clevertec.check.utils.argparser.LaunchOptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CheckServiceImpl implements CheckService {
    private final ProductService productService;
    private final DiscountService discountService;

    public CheckServiceImpl(ProductService productService, DiscountService discountService) {
        this.productService = productService;
        this.discountService = discountService;
    }

    @Override
    public CheckDTO createCheck(LaunchOptions options) {
        Optional<DiscountCard> discountCard = discountService.findByCardNum(options.getDiscountCardNum());
        Map<Product, Integer> productCountMap = productService.getProductEntityByOptions(options);

        double totalPrice = 0;
        double totalDiscountSum = 0;
        double totalPriceWithDiscount = 0;

        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Map.Entry<Product, Integer> productCount : productCountMap.entrySet()) {
            Product product = productCount.getKey();

            int discountPercentages = getDiscountPercentage(product, productCount.getValue(), discountCard);
            double productPriceWithDiscount = calculationPriceWithDiscount(product.getPrice(), discountPercentages);
            double productDiscount = product.getPrice() - productPriceWithDiscount;
            productDTOs.add(new ProductDTO.Builder()
                    .setProductId(product.getId())
                    .setDescription(product.getDescription())
                    .setPrice(product.getPrice())
                    .setDiscount(productDiscount)
                    .setTotalPrice(productPriceWithDiscount)
                    .setAmount(productCount.getValue())
                    .build()
            );
            totalPrice += product.getPrice();
            totalDiscountSum += productDiscount;
            totalPriceWithDiscount += productPriceWithDiscount;
        }

        CheckDTO checkDTO = new CheckDTO();
        checkDTO.setCreated(LocalDateTime.now());
        checkDTO.setProductsInfoList(productDTOs);
        checkDTO.setDiscountCard(discountCard);
        checkDTO.setTotalPriceDTO(new TotalPriceDTO.Builder()
                .setTotalPrice(totalPrice)
                .setTotalDiscount(totalDiscountSum)
                .setTotalPriceWithDiscount(totalPriceWithDiscount)
                .build()
        );
        return checkDTO;
    }

    private double calculationPriceWithDiscount(double price, int discountPercentages) {
        return (price * (100 - discountPercentages) / 100);
    }

    private int getDiscountPercentage(Product product, int count, Optional<DiscountCard> discountCard) {
        if (product.isWholesale() && count >= 5) {
            return 10;
        }
        if (discountCard.isPresent()) {
            return discountCard.get().getDiscountAmount();
        }
        return 0;
    }
}
