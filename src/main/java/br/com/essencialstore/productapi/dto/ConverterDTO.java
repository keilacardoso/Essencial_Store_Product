package br.com.essencialstore.productapi.dto;

import br.com.essencialstore.productapi.model.Category;
import br.com.essencialstore.productapi.model.Product;

public class ConverterDTO {
    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        if(product.getCategory() != null){
            productDTO.setCategory(ConverterDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}
