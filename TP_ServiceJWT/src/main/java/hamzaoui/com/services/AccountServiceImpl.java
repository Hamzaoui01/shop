package hamzaoui.com.services;

import javax.transaction.Transactional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hamzaoui.com.dao.AppRoleRepository;
import hamzaoui.com.dao.AppUserRepository;
import hamzaoui.com.entities.AppRole;
import hamzaoui.com.entities.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		// TODO Auto-generated method stub
		AppUser user = appUserRepository.findByUsername(username);
		if (user != null)
			throw new RuntimeException("User already exists");
		if (!password.equals(confirmedPassword))
			throw new RuntimeException("paswords does not much");
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setActived(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepository.save(appUser);
		addRoleToUser(username, "USER");

		return appUser;
	}

	@Override
	public AppRole save(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		AppUser user = loadUserByUsername(username);
		AppRole role = appRoleRepository.findByRoleName(rolename);
		user.getRoles().add(role);
	}
}
