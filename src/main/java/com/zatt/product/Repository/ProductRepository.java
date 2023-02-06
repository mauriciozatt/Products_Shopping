package com.zatt.product.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zatt.product.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByCodigo(String codigo);

	// Quando uso HQL sempre deve ser feito o SQL sobre a entity e não sobre a
	// tabela como no SQL nativo..
	@Query("SELECT p FROM Product p JOIN Category c ON p.category = c.id WHERE c.id = :id")
	public List<Product> getProductByCategory(@Param("id") Long id);

}
