package main.java.ru.clevertec.check.dto;

import main.java.ru.clevertec.check.model.DiscountCard;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CheckDTO {
    private LocalDateTime created;
    private Optional<DiscountCard> discountCard;
    private List<ProductDTO> productsInfoList;
    private TotalPriceDTO totalPriceDTO;

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Optional<DiscountCard> getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(Optional<DiscountCard> discountCard) {
        this.discountCard = discountCard;
    }

    public List<ProductDTO> getProductsInfoList() {
        return productsInfoList;
    }

    public void setProductsInfoList(List<ProductDTO> productsInfoList) {
        this.productsInfoList = productsInfoList;
    }

    public TotalPriceDTO getTotalPriceDTO() {
        return totalPriceDTO;
    }

    public void setTotalPriceDTO(TotalPriceDTO totalPriceDTO) {
        this.totalPriceDTO = totalPriceDTO;
    }
}
