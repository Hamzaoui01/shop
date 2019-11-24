package hamzaoui.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import hamzaoui.com.entities.AppUser;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String userame);
}
