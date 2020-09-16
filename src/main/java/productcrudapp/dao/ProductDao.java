package productcrudapp.dao;
import productcrudapp.model.Product;
import java.util.*;

import org.springframework.stereotype.Repository;
//Interface for defining data access functions
public interface ProductDao {
//function definition for creating product 
public void createProduct(Product product);

//function definition for deleting product
public void deleteProduct(int id);

//function definition for fetching particular product
public Product getProduct(int id);

//function definition for getting all products
public List<Product> getAllProducts();


//function definition for updating all products
public void updateProduct(Product product);
}
