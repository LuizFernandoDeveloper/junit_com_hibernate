package dao;

import domain.CarBrand;

public class CarBrandDAO implements IDAO<CarBrand, Long> {

	@Override
	public Class<CarBrand> getEntityClass() {
		
		return CarBrand.class;
		
	}

}
