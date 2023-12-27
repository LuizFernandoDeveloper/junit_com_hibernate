package exemploMod32;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import dao.ProductDAO;
import domain.Product;

public class ProductTest {

	private ProductDAO productDao;

	public ProductTest() {

		productDao = new ProductDAO();

	}

	@After
	public void end() {

		List<Product> list = productDao.findAll();
		if (list != null) {
			list.forEach(obj -> productDao.excluir(obj));
		}
	}

	@Test
	public void register() {

		Product productDB = methodRegisterInDb();
		assertNotNull(productDB);
		assertNotNull(productDB.getId());

	}

	@Test
	public void update() {

		Product productDB = methodFindByIdInDB();
		productDB.setCode("test");

		Product productUpdate = productDao.update(productDB);
		assertEquals("test", productUpdate.getCode());

	}

	@Test
	public void delete() {

		Product productDB = methodFindByIdInDB();
		productDao.excluir(productDB);

		Product productIsDelete = productDao.findById(productDB.getId());
		assertNull(productIsDelete);
		assertNotEquals(productDB, productIsDelete);

	}

	@Test
	public void findById() {

		assertNotNull(methodFindByIdInDB());

	}

	@Test
	public void findAll() {

		List<Product> ProductList = productDao.findAll();
		assertNotNull(ProductList);
	}

	private Product methodFindByIdInDB() {

		Product product = methodRegisterInDb();
		assertNotNull(product);

		Product productDB = productDao.findById(product.getId());
		assertNotNull(productDB);
		assertEquals(product, productDB);

		return productDB;

	}

	private Product methodRegisterInDb() {

		Product product = newObj();
		product = productDao.Register(product);
		return product;

	}

	public Product newObj() {

		Product product = new Product(
				"Smart Phone",
				"157", 
				"O smartphone é um celular com tecnologias avançadas"
				);
		
		return product;

	}
}
