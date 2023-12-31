package exemploMod32;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import dao.CarDAO;
import domain.Car;
import domain.CarAccessory;
import domain.CarBrand;
import enums.Accessory;
import enums.Brand;
import enums.CarColor;
import enums.CarType;

public class CarTest {

	private CarDAO carDao;

	public CarTest() {

		carDao = new CarDAO();

	}

	@After
	public void end() {

		List<Car> list = carDao.findAll();
		if (list != null) {
			
			list.forEach(obj -> carDao.excluir(obj));
			
		}
		
	}

	@Test
	public void register() {

		Car carDB = methodRegisterInDb();
		assertNotNull(carDB);
		assertNotNull(carDB.getId());

	}

	@Test
	public void update() {

		Car carDB = methodFindByIdInDB();
		carDB.setLicensePlate("test");

		Car carUpdate = carDao.update(carDB);
		assertEquals("test", carUpdate.getLicensePlate());

	}

	@Test
	public void delete() {

		Car carDB = methodFindByIdInDB();
		carDao.excluir(carDB);

		Car carIsDelete = carDao.findById(carDB.getId());
		assertNull(carIsDelete);
		assertNotEquals(carDB, carIsDelete);

	}

	@Test
	public void findById() {

		assertNotNull(methodFindByIdInDB());

	}

	@Test
	public void findAll() {

		List<Car> CarList = carDao.findAll();
		assertNotNull(CarList);

	}

	private Car methodFindByIdInDB() {

		Car car = methodRegisterInDb();
		assertNotNull(car);

		Car carDB = carDao.findById(car.getId());
		assertNotNull(carDB);
		assertEquals(car, carDB);

		return carDB;

	}

	private Car methodRegisterInDb() {

		Car car = newObj();
		car = carDao.Register(car);
		return car;

	}

	public Car newObj() {
		
		Car car = new Car(
				
				"RR45-56JJ",
				CarColor.STEEL, 
				CarType.PICKUP_TRUCKS, 
				null, 
				null 
				
				);
		
		CarBrand carBrand = new CarBrand(
				
				Brand.DODGE_RAM, 
				car
				
				);
		
		List<CarAccessory> listAccessory = new ArrayList<>();
		listAccessory.add(
				
				new CarAccessory( 
						
						Accessory.GIANTE_CAR_WHEELS, 
						car
						
						));
		listAccessory.add(
				
				new CarAccessory( 
						
						Accessory.FOR_IRON_SHOCK, 
						car
						
						));
		
		car.setListAccessory(listAccessory);
		car.setBrand(carBrand);
		
		return car;

	}
}
