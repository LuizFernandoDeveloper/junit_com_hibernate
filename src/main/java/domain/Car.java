package domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enums.CarColor;
import enums.CarType;

@Entity
@Table(name = "TB_Car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
	@SequenceGenerator(name = "car_seq", sequenceName = "sq_Car", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "Car_License_Plate", length = 20, nullable = false)
	private String licensePlate;

	@Column(name = "Car_Color", length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private CarColor color;

	@Column(name = "Car_Type", length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private CarType type;

	@OneToOne(mappedBy = "car" , cascade = CascadeType.ALL)
	private CarBrand brand;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private List<CarAccessory> listAccessory;

	public Car() {

	}

	public Car(String licensePlate, CarColor color, CarType type, CarBrand brand, List<CarAccessory> listAccessory) {

		this.licensePlate = licensePlate;
		this.color = color;
		this.type = type;
		this.brand = brand;
		this.listAccessory = listAccessory;
		
	}

	public Car(Long id, String licensePlate, CarColor color, CarType type, CarBrand brand, List<CarAccessory> listAccessory) {

		this.id = id;
		this.licensePlate = licensePlate;
		this.color = color;
		this.type = type;
		this.brand = brand;
		this.listAccessory = listAccessory;
		
	}

	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}

	public String getLicensePlate() {
		
		return licensePlate;
		
	}

	public void setLicensePlate(String licensePlate) {
		
		this.licensePlate = licensePlate;
		
	}

	public CarColor getColor() {
		
		return color;
		
	}

	public void setColor(CarColor color) {
		
		this.color = color;
		
	}

	public CarType getType() {
		
		return type;
		
	}

	public void setType(CarType type) {
		
		this.type = type;
		
	}

	public CarBrand getBrand() {
		
		return brand;
		
	}

	public void setBrand(CarBrand brand) {
		
		this.brand = brand;
		
	}

	public List<CarAccessory> getListCarAccessory(){
		
		return listAccessory;
		
	}

	public void setListAccessory(List<CarAccessory> listAccessory) {
		
		this.listAccessory = listAccessory;
		
	}
	
	public void addListAccessory(CarAccessory accessory) {
		
		this.listAccessory.add(accessory);
		
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(id);
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(id, other.id);
		
	}
}