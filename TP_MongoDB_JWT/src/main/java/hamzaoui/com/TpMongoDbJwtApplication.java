package hamzaoui.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hamzaoui.com.dao.CategorieRepository;
import hamzaoui.com.dao.ProductRepository;
import hamzaoui.com.entities.Categorie;
import hamzaoui.com.entities.Product;

@SpringBootApplication
public class TpMongoDbJwtApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TpMongoDbJwtApplication.class, args);
	}
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categorie c1 = new Categorie("1","categorie 1");
		Categorie c2 = new Categorie("2","categorie 2");
		c1.setBublished(true);
		c2.setBublished(true);
				
		Product p1=new Product("1","Product 1",29,92.8,c1);
		Product p2=new Product("2","Product 2",29,92.8,c2);
		Product p3=new Product("3","Product 3",29,92.8,c1);
		p1.setPublished(true);
		p2.setPublished(true);

		categorieRepository.save(c1);
		categorieRepository.save(c2);
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
		c1.getProducts().add(p1);
		c1.getProducts().add(p2);
		c1.getProducts().add(p3);
		
		categorieRepository.save(c1);
		
		productRepository.findAll().forEach(e->System.out.println(e.toString()));

	}

}
