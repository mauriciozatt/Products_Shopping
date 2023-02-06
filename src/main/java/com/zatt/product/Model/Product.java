package com.zatt.product.Model;

import com.zatt.product.Dto.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private float preco;

	// Primeira palavra se refere a classe...
	// Ou Seja vários produtos pode possuir apenas uma categoria...
	// JoinColumn(o name vai receber a coluna que irá fazer o join... o próprio JPA
	// fará o join com o ID da entidade Category.. )
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public static Product convertToProduct(ProductDto dto) {

		Product product = new Product();

		product.setCodigo(dto.getCodigo());
		product.setNome(dto.getNome());
		product.setDescricao(dto.getDescricao());
		product.setPreco(dto.getPreco());

		if (dto.getCategory() != null) {
			Category cat = Category.convertToCategory(dto.getCategory());
			product.setCategory(cat);
		}

		return product;

	}

}
