package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class Product  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "sq_Product", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "Product_Name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "Product_Code", length = 500, nullable = false)
	private String code;
	
	@Column(name = "Product_Description", length = 1000, nullable = false)
	private String description;
	
	public Product() {
		
	}
	
	public Product(String name, String code, String description) {
		
		this.name = name;
		this.code = code;
		this.description = description;
	}



	public Product(Long id, String name, String code, String description) {
		
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}
