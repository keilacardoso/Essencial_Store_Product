package br.com.essencialstore.productapi.controller;

import br.com.essencialstore.productapi.dto.ProductDTO;
import br.com.essencialstore.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts(){
        List<ProductDTO> products = productService.getAll();
        return products;
    }
    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId){
        List<ProductDTO> products = productService.getProductByCategoryId(categoryId);
        return products;
    }
    @GetMapping("/product/{productIdentifier}")
    ProductDTO findbyId(@PathVariable String productIdentifier){
        return productService.findByProductIdentifier(productIdentifier);
    }
    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }
    @DeleteMapping("/product/{id}")
    ProductDTO delete(@PathVariable Long id) throws HttpClientErrorException.NotFound {
        return productService.delete(id);
    }

}
