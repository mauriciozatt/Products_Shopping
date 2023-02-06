package com.zatt.product.Dto;

import com.zatt.product.Model.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {

	@NotNull
	private Long id;

	@NotBlank
	private String nome;

	public static CategoryDto convertToDto(Category cat) {

		CategoryDto dto = new CategoryDto();

		dto.setId(cat.getId());
		dto.setNome(cat.getNome());

		return dto;
	};

}
