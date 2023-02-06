package com.zatt.product.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.zatt.product.Dto.ProductDto;
import com.zatt.product.Model.Product;
import com.zatt.product.Repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;

	// injeção de dependência
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	};

	// getAll
	public List<ProductDto> getAll() {

		// Recupero a lista e converto para uma lista de ProductDTO
		List<Product> vListaProduto = productRepository.findAll();

		if (!vListaProduto.isEmpty()) {

			List<ProductDto> vListaProductDTO = new ArrayList<ProductDto>();

			for (Product prod : vListaProduto) {
				vListaProductDTO.add(ProductDto.convertToDto(prod));
			}

			return vListaProductDTO;
		}

		return null;
	}

	// Buscar produto pelo código...
	public ProductDto getProductByCodigo(String codigo) {

		Product produto = productRepository.findByCodigo(codigo);

		if (produto != null) {
			return ProductDto.convertToDto(produto);
		}

		return null;
	}

	// Buscar todos os produtos de uma determinada categoria...
	public List<ProductDto> getProductsByCategoryId(Long id) {

		// retorn uma lista de product
		List<Product> vListaProdutos = productRepository.getProductByCategory(id);

		if (!vListaProdutos.isEmpty()) {

			List<ProductDto> vListProductDto = new ArrayList<ProductDto>();

			for (Product prod : vListaProdutos) {
				vListProductDto.add(ProductDto.convertToDto(prod));
			}

			return vListProductDto;
		}

		return null;

	}

	public List<ProductDto> getProductsByCategoryId1(Long id) {

		// retorn uma lista de product
		List<Product> vListaProdutos = productRepository.getProductByCategory(id);

		return vListaProdutos.stream().map(ProductDto::convertToDto).collect(Collectors.toList());

	}

	// save

	public ProductDto salvar(ProductDto dto) {

		Product product = Product.convertToProduct(dto);

		product = productRepository.save(product);

		return ProductDto.convertToDto(product);
	}

	/// delete

}
