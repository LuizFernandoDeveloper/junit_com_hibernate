package dao;

import domain.Car;

public class CarDAO implements IDAO<Car, Long>{

	@Override
	public Class<Car> getEntityClass() {
		
		return Car.class;
		
	}

}
