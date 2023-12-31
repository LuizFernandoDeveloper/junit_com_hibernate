package dao;

import domain.CarAccessory;

public class CarAccessoryDAO implements IDAO<CarAccessory, Long> {

	@Override
	public Class<CarAccessory> getEntityClass() {
		
		return CarAccessory.class;
		
	}

}
