package ru.kors.giftstore.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.kors.giftstore.model.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ProductDTO
        extends GenericDTO {
    private String productName;
    private String manufacturer;
    private LocalDate productionDate;
    private Integer quantity;
    private String storageLocation;
    private String digitalContentUrl;
    private String description;
    private BigDecimal price;
    private String ageGroup;
    private ProductCategory category;
    private String material;
    private String dimensions;

}

