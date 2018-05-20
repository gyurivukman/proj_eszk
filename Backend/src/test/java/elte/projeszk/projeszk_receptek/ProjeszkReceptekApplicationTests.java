package elte.projeszk.projeszk_receptek;

import elte.projeszk.projeszk_receptek.model.User;
import elte.projeszk.projeszk_receptek.repository.UserRepository;
import elte.projeszk.projeszk_receptek.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjeszkReceptekApplicationTests {

	private static final String USERNAME = "UserAnimal";

	private UserRepository userRepository;
	private UserService userService;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Before
	public void init() {
		userService.signUp(USERNAME, "Kukken", "Mukken", "Almafa1234", "example@example.com", true);
	}

	@Test
	public void signUpTest() {
		Map<String, String> result;
		result = userService.signUp("", "", "", "", "", false);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("", "Kukken", "Mukken", "Almafa1234", "test@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp(USERNAME, "Kukken", "Mukken", "Almafa1234", "test@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "", "Mukken", "Almafa1234", "test@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "Kukken", "", "Almafa1234", "test@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "Kukken", "Mukken", "", "test@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "Kukken", "Mukken", "Almafa1234", "", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "Kukken", "Mukken", "Almafa1234", "example@example.com", true);
		assertFalse("Bad response to sign up.", result.isEmpty());

		result = userService.signUp("UserAnimalTest", "Kukken", "Mukken", "Almafa1234", "test@example.com", false);
		assertFalse("Bad response to sign up.", result.isEmpty());
	}

	@Test
	public void Login() {
		Optional<User> optional = userRepository.findByUsername(USERNAME);

		optional.ifPresent(user ->
				assertNotNull("Bad response to Login.", userService.login(user.getUsername(), user.getPassword())));

		assertNull("Bad response to Login.", userService.login("UserAnimalTest", "Almafa1234"));
		assertNull("Bad response to Login.", userService.login("UserAnimal", "Almafa123"));
	}

	@After
	public void end() {
		Optional<User> optional = userRepository.findByUsername(USERNAME);
		optional.ifPresent(user -> userRepository.delete(user));
	}
}
