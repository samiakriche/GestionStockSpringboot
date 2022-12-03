package org.sic.Projet_GestionDesStock.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByName(String name);

	@Query(value = "SELECT u.* FROM Product u where u.category_id = :id", nativeQuery = true)
	List<Product> getProductsId(@Param("id") long id);

	@Modifying
	@Transactional
	@Query(value = "delete from Product where category_id = :id", nativeQuery = true)
	int DeleteCatagorieProducts(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "delete from supplier_product where product_id in (select id Product where category_id = :id)", nativeQuery = true)
	int DeleteCatagorieProductsOfSupplier(@Param("id") Long id);

}
