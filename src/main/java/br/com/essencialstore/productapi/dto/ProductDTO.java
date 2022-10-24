package br.com.essencialstore.productapi.dto;

import br.com.essencialstore.productapi.model.Product;
import javax.validation.constraints.NotBlank;

public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private float price;
    @NotBlank
    private CategoryDTO category;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public static ProductDTO convert(Product product){
        ProductDTO productDto = new ProductDTO();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setProductIdentifier(product.getProductIdentifier());
        productDto.setDescription(product.getDescription());

        if(product.getCategory() != null){
            productDto.setCategory(CategoryDTO.convert(product.getCategory()));
        }

        return productDto;
    }
}
