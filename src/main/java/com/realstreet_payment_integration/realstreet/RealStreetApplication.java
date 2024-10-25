package com.realstreet_payment_integration.realstreet;

import com.realstreet_payment_integration.realstreet.model.Role;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RealStreetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RealStreetApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		UserEntity admin = userRepository.findByRole(Role.ADMIN);
		if (admin == null){
			UserEntity user = new UserEntity();
			user.setUsername("admin1995");
			user.setEmail("admin@gmail.com");
			user.setPassword(new BCryptPasswordEncoder().encode("admin1234"));
			user.setPhoneNumber("2212345574");
			user.setRole(Role.ADMIN);
			userRepository.save(user);
		}

	}
}
