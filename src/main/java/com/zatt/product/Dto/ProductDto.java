package com.zatt.product.Dto;

import com.zatt.product.Model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

	@NotBlank
	private String codigo;

	@NotBlank
	private String nome;

	private String descricao;

	@NotNull
	private float preco;

	@NotNull
	private CategoryDto category;

	
	public static ProductDto convertToDto(Product product) {

		ProductDto dto = new ProductDto();

		dto.setCodigo(product.getCodigo());
		dto.setNome(product.getNome());
		dto.setDescricao(product.getDescricao());
		dto.setPreco(product.getPreco());

		if (product.getCategory() != null) {
			dto.setCategory(CategoryDto.convertToDto(product.getCategory()));
		}

		return dto;
	}

}
