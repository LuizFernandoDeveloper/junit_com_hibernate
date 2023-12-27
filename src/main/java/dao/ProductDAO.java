package dao;

import domain.Product;

public class ProductDAO implements IDAO<Product, Long> {

	@Override
	public Class<Product> getEntityClass() {
		
		return Product.class;
	}
	
	
	
}
