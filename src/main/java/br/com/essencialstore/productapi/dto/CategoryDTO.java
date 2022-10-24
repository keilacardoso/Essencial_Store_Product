package br.com.essencialstore.productapi.dto;

import br.com.essencialstore.productapi.model.Category;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }
}
