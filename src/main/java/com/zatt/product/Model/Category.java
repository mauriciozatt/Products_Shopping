package com.zatt.product.Model;

import com.zatt.product.Dto.CategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public static Category convertToCategory(CategoryDto dto) {

		Category category = new Category();

		category.setId(dto.getId());
		category.setNome(dto.getNome());

		return category;

	}

}
