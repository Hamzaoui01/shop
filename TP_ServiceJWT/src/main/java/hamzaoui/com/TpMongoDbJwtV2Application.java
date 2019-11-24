package hamzaoui.com;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hamzaoui.com.entities.AppRole;
import hamzaoui.com.entities.AppUser;
import hamzaoui.com.services.AccountService;

@SpringBootApplication
public class TpMongoDbJwtV2Application {

	public static void main(String[] args) {
		SpringApplication.run(TpMongoDbJwtV2Application.class, args);
	}
	
	@Bean 
	CommandLineRunner start(AccountService accountService) {
		return args->{
			accountService.save(new AppRole(null,"USER"));
			accountService.save(new AppRole(null,"ADMIN"));
			Stream.of("user1","user2","user3","admin").forEach(u->{
				AppUser us=accountService.saveUser(u, "1234", "1234");
				if(u.contains("admin"))accountService.addRoleToUser("admin","ADMIN");
			});
		};
	}	
	
	@Bean
	BCryptPasswordEncoder getCrp() {
		return new BCryptPasswordEncoder();
	}

}
