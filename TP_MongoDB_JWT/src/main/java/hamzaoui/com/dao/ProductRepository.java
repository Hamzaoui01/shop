package hamzaoui.com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import hamzaoui.com.entities.Product;

@CrossOrigin(allowCredentials="localhost:4200")
public interface ProductRepository extends MongoRepository<Product, String> {

}
