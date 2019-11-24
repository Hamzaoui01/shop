package hamzaoui.com.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hamzaoui.com.dao.ProductRepository;
import hamzaoui.com.entities.Product;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/cproducts")
	Collection<Product> getProducts(){
		Collection<Product> products=new ArrayList<Product>();
		for(Product p:productRepository.findAll()) {
			if(p.isPublished())products.add(p);
		}			
		return products;
	}
}
