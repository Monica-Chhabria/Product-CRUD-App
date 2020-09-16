package productcrudapp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.Logging.ProductLogger;
import productcrudapp.model.Product;
import productcrudapp.service.ProductService;
//Application Controller
@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
//handler for getting list of products
@RequestMapping("/")
public String home(Model m)
{
    List<Product> productList = this.productService.getAllProducts();
	m.addAttribute("product",productList);
    return "index";
}
//handler for adding products
@RequestMapping("/add-product")
public String addproduct(Model m)
{
    ProductLogger.LogMsg("Inside add products function");
	m.addAttribute("title","Add Product");
    return "add_product_form";
}
//handler for redirecting to home page
@RequestMapping("/handle-product")
public RedirectView handleProduct(@ModelAttribute("Product") Product p,BindingResult br,HttpServletRequest req  )
{
	ProductLogger.LogMsg("Inside handleProduct function");
	RedirectView rv = new RedirectView();

	if(br.hasErrors())
	{
		//redirectAttrs.addFlashAttribute("errorMessage","error");
	//redirectView.setContextRelative(true);
		rv.setUrl(req.getContextPath()+"/add-product");
		
		return rv;
		
	}
	else
	{
		
		this.productService.createProduct(p);
		
		rv.setUrl(req.getContextPath()+"/");
	
	return rv;
	}
}
//handler for deleting product
@RequestMapping("/delete/{id}")
public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest req)

{
	ProductLogger.LogMsg("Inside deleteProduct function");
	this.productService.deleteProduct(id);
	RedirectView rv = new RedirectView();
	rv.setUrl(req.getContextPath()+"/");
	
	return rv;

}
//handler for updating product
@RequestMapping("/update/{id}")
public String updateProduct(@PathVariable("id") int id ,Model m)

{
	ProductLogger.LogMsg("Inside updateProduct function");
	Product product = this.productService.getProduct(id);
	//RedirectView rv = new RedirectView();
	//rv.setUrl(req.getContextPath()+"/");
	m.addAttribute("product",product);
	return "update_product_form";

}

/*@RequestMapping("/update/{id}")
public String updateProduct(@PathVariable("id") int id ,Model m)

{
if()
	
{}
	Product product = this.productService.getProduct(id);
	//RedirectView rv = new RedirectView();
	//rv.setUrl(req.getContextPath()+"/");
	m.addAttribute("product",product);
	return "update_product_form";

}
}
*/
}