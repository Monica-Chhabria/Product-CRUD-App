package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.Logging.ProductLogger;
import productcrudapp.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
    
	@Autowired
	public HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	//function for creating product 
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		ProductLogger.LogMsg("inside createProduct function");
		this.hibernateTemplate.saveOrUpdate(product);

	}
	//function for deleting product
	@Override
	@Transactional
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		ProductLogger.LogMsg("inside deleteProduct function");
		Product product = this.hibernateTemplate.get(Product.class, id);
		this.hibernateTemplate.delete(product);
	}
	//function for fetching particular product
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		ProductLogger.LogMsg("inside getProduct function");
		Product product = this.hibernateTemplate.get(Product.class, id);
		return product;
	}
	//function for getting all products
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		ProductLogger.LogMsg("inside getAllProducts function");
		List<Product> prodList = this.hibernateTemplate.loadAll(Product.class);
		return prodList;
	}
	//function for updating all products
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		ProductLogger.LogMsg("inside updateProduct function");
		 this.hibernateTemplate.update(product);
	}

}
