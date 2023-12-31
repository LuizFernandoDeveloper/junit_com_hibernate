package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import enums.Accessory;

@Entity
@Table(name = "TB_CarAccessory")
public class CarAccessory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accessory_seq")
	@SequenceGenerator(name = "accessory_seq", sequenceName = "sq_accessory", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "Car_Accessory", length = 300, nullable = false)
	@Enumerated(EnumType.STRING)
	private Accessory accessory;

	@ManyToOne
	@JoinColumn(
			
		name = "id_car_fk",
		foreignKey = @ForeignKey(name = "fk_car_accessory"),
		referencedColumnName = "id", 
		nullable = false
	
	)
	private Car car;

	public CarAccessory() {

	}

	public CarAccessory(Accessory accessory, Car car) {

		this.accessory = accessory;
		this.car = car;

	}

	public CarAccessory(Long id, Accessory accessory, Car car) {

		this.id = id;
		this.accessory = accessory;
		this.car = car;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public Accessory getAccessory() {

		return accessory;

	}

	public void setAccessory(Accessory accessory) {

		this.accessory = accessory;

	}

	@Override
	public int hashCode() {

		return Objects.hash(accessory, id);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarAccessory other = (CarAccessory) obj;
		return accessory == other.accessory && Objects.equals(id, other.id);

	}

}
