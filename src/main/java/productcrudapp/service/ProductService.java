package productcrudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcrudapp.dao.ProductDao;
import productcrudapp.dao.ProductDaoImpl;
import productcrudapp.model.Product;
//Service class for crud operations
@Service
public class ProductService {

	@Autowired
private ProductDao productDaoImpl;


public ProductDao getProductDaoImpl() {
		return productDaoImpl;
	}

	public void setProductDaoImpl(ProductDao productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	//function for creating product 
public void createProduct(Product product)
{
	
	this.productDaoImpl.createProduct(product);
	//return prodid;
}
//function for getting all products
public List<Product> getAllProducts()

{
	List<Product> prodList = this.productDaoImpl.getAllProducts();	
    return prodList;
}
//function for deleting product
public void deleteProduct(int id)
{
	this.productDaoImpl.deleteProduct(id);
}
//function for fetching particular product
public Product getProduct(int id)
{
	
	 Product prod = this.productDaoImpl.getProduct(id);
	return prod;
}
}
