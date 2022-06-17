package com.example.springsecuritywithjwt;

import com.example.springsecuritywithjwt.domain.AppUser;
import com.example.springsecuritywithjwt.domain.Role;
import com.example.springsecuritywithjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJwtApplication implements CommandLineRunner {

	private final UserService userService;

	@Lazy
	public SpringSecurityWithJwtApplication(UserService userService) {
		this.userService = userService;
	}

//  setter dependency injection:
//	@Lazy
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		initialiseRolesAndUsers();
	}

	private void initialiseRolesAndUsers() {

		userService.saveRole(new Role(null, "ROLE_USER"));
		userService.saveRole(new Role(null, "ROLE_MANAGER"));
		userService.saveRole(new Role(null, "ROLE_ADMIN"));
		userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

		userService.saveUser(new AppUser(null, "Cindy Crawford", "cindy", "password", new ArrayList<>()));
		userService.saveUser(new AppUser(null, "Samantha Fox", "samantha", "password", new ArrayList<>()));
		userService.saveUser(new AppUser(null, "Lisa Boyle", "lisa", "password", new ArrayList<>()));
		userService.saveUser(new AppUser(null, "Brigitte Nielsen", "brigitte", "password", new ArrayList<>()));

		userService.addRoleToUser("cindy", "ROLE_USER");
		userService.addRoleToUser("cindy", "ROLE_MANAGER");
		userService.addRoleToUser("samantha", "ROLE_MANAGER");
		userService.addRoleToUser("lisa", "ROLE_ADMIN");
		userService.addRoleToUser("brigitte", "ROLE_USER");
		userService.addRoleToUser("brigitte", "ROLE_ADMIN");
		userService.addRoleToUser("brigitte", "ROLE_SUPER_ADMIN");

	}
}
