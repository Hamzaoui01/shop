package hamzaoui.com.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hamzaoui.com.dao.CategorieRepository;
import hamzaoui.com.dao.ProductRepository;
import hamzaoui.com.entities.Categorie;
import hamzaoui.com.entities.Product;

@RestController
public class CategorieController {
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ProductRepository productRepository;
	@RequestMapping(path="/ccategories")
	Collection<Categorie> getCategories(){		
		Collection<Categorie> cats=new ArrayList<Categorie>();
		for(Categorie c:categorieRepository.findAll()) {
			if(c.isBublished())cats.add(c);
		}
		return cats;
	}
	
	@RequestMapping(path="/ccategories/{id}")
	Collection<Product> getProducts(@PathVariable("id")String id){
		Optional<Categorie> oc=categorieRepository.findById(id);
		if(!oc.isPresent())throw new RuntimeException("Wrong id for categorie");
		Categorie c=oc.get();
		if(!c.isBublished())throw new RuntimeException("Categorie not yet published");
		
		Collection<Product> products=new ArrayList<Product>();
		for(Product p:productRepository.findAll()) {
			System.out.println("test de "+p.getName());
			if(p.getCategorie().getId()==c.getId()) {
				System.out.println("same categorie "+p.getCategorie().getName());
				if(p.isPublished())products.add(p);
			}	
		}			
		return products;
	}
}
