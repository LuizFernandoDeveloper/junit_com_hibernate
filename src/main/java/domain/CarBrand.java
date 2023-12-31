package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enums.Brand;

@Entity
@Table(name = "TB_CarBrand")
public class CarBrand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_brand_seq")
	@SequenceGenerator(name = "car_brand_seq", sequenceName = "sq_car_brand", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "Car_Brand")
	@Enumerated(EnumType.STRING)
	private Brand brand;

	@OneToOne
	@JoinColumn(name = "car_id")
	private Car car;

	public CarBrand() {

	}

	public CarBrand( Brand brand, Car car) {

		this.brand = brand;
		this.car = car;

	}

	public CarBrand(Long id, Brand brand, Car car) {

		this.id = id;
		this.brand = brand;
		this.car = car;

	}

	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}

	public Brand getBrand() {
		
		return brand;
		
	}

	public void setBrand(Brand brand) {
		
		this.brand = brand;
		
	}

	public Car getCar() {
		
		return car;
		
	}

	public void setCar(Car car) {
		
		this.car = car;
		
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
		CarBrand other = (CarBrand) obj;
		return Objects.equals(id, other.id);
		
	}
}
