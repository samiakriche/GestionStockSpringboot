package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategotyService {

	@Autowired
	private CategoryRepository categoryRepository;

//    Add Item
	public Category saveItem(Category category) {

		return categoryRepository.save(category);
	}

	// Get all Items
	public List<Category> getAll() {

		return categoryRepository.findAll();
	}

//    Get Item By Id
	public Category getById(long id) {
		return categoryRepository.findById(id).get();
	}

//    Delete Item By Id

	public void deleteById(long id) {
		// categoryRepository.DeleteCatagorieProductsOfSupplier(id);
		// categoryRepository.DeleteCatagorieProducts(id);
		categoryRepository.deleteById(id);
	}

	public List<Product> getProducts(long id) {
		return categoryRepository.getProductsId(id);
	}

////    Update Item
//	public Category updateItem(Category category) {
//		return null;
//	}

}
