package hamzaoui.com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import hamzaoui.com.entities.Categorie;

@CrossOrigin(origins = "http://localhost:4200")
public interface CategorieRepository extends MongoRepository<Categorie, String> {
	

}
