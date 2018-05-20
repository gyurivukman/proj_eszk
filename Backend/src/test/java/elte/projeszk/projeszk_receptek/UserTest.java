package elte.projeszk.projeszk_receptek;

import elte.projeszk.projeszk_receptek.model.User;
import elte.projeszk.projeszk_receptek.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserTest {

    private List<User> validUser;

    @Before
    public void init() {
        validUser = new ArrayList<>(Arrays.asList(
                new User("UserAnimal", "Kukken", "Mukken", "example@example.com", "Almafa1234", null, null, null),
                new User("admin", "Mikorka", "Kálmán", "admin_example@example.com", "Almafa1234", null, null, null)
        ));
    }

    @Test
    public void validUsernameTest() {
        assertFalse("Check validUsername() method.", UserService.validUsername(null));
        assertFalse("Check validUsername() method.", UserService.validUsername(""));
        assertFalse("Check validUsername() method.", UserService.validUsername("w"));
        assertFalse("Check validUsername() method.", UserService.validUsername("wa"));
        assertFalse("Check validUsername() method.", UserService.validUsername("user animal"));
        assertFalse("Check validUsername() method.", UserService.validUsername("feeeeeeeeeeeee"));


        assertTrue("Check validUsername() method.", UserService.validUsername("Admin"));
        assertTrue("Check validUsername() method.", UserService.validUsername("admin"));
        assertTrue("Check validUsername() method.", UserService.validUsername("userAnimal"));
        assertTrue("Check validUsername() method.", UserService.validUsername("user1995"));
        assertTrue("Check validUsername() method.", UserService.validUsername("UserAnimal91"));

        validUser.forEach(u -> assertTrue("Check validUsername() method.", UserService.validUsername(u.getUsername())));
    }

    @Test
    public void validNameTest() {
        assertFalse("Check validName() method.", UserService.validName(null));
        assertFalse("Check validName() method.", UserService.validName(""));
        assertFalse("Check validName() method.", UserService.validName("d"));
        assertFalse("Check validName() method.", UserService.validName("fe"));
        assertFalse("Check validName() method.", UserService.validName("ferenc"));
        assertFalse("Check validName() method.", UserService.validName(" Ferenc"));
        assertFalse("Check validName() method.", UserService.validName("Ferenc "));
        assertFalse("Check validName() method.", UserService.validName("Fere nc"));
        assertFalse("Check validName() method.", UserService.validName(" Ferenc"));
        assertFalse("Check validName() method.", UserService.validName("FeRenc"));
        assertFalse("Check validName() method.", UserService.validName("Feeeeeeeeeeeee"));

        assertTrue("Check validName() method.", UserService.validName("Dávid"));
        assertTrue("Check validName() method.", UserService.validName("Ferenc"));
        assertTrue("Check validName() method.", UserService.validName("Gizi"));

        validUser.forEach(u -> {
            assertTrue("Check validName() method.", UserService.validName(u.getForeName()));
            assertTrue("Check validName() method.", UserService.validName(u.getSurName()));
        });
    }

    @Test
    public void validEmailTest() {
        assertFalse("Check validEmail() method.", UserService.validEmail(null));
        assertFalse("Check validEmail() method.", UserService.validEmail(""));
        assertFalse("Check validEmail() method.", UserService.validEmail("fgawhwhaj"));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@"));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@example"));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@example."));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@example.d"));
        assertFalse("Check validEmail() method.", UserService.validEmail(" example@example.hu"));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@example.hu "));
        assertFalse("Check validEmail() method.", UserService.validEmail("example@example.hu fgwaeg"));

        assertTrue("Check validEmail() method.", UserService.validEmail("example@example.com"));
        assertTrue("Check validEmail() method.", UserService.validEmail("valid_mail@example.hu"));
        assertTrue("Check validEmail() method.", UserService.validEmail("valid.mail.example@example.com"));

        validUser.forEach(u -> assertTrue("Check validEmail() method.", UserService.validEmail(u.getEmail())));
    }

    @Test
    public void validPasswordTest() {
        assertFalse("Check validEmail() method.", UserService.validPassword(null));
        assertFalse("Check validEmail() method.", UserService.validPassword(""));
        assertFalse("Check validEmail() method.", UserService.validPassword("awf"));
        assertFalse("Check validEmail() method.", UserService.validPassword("awfdw"));
        assertFalse("Check validEmail() method.", UserService.validPassword("Awfdw"));
        assertFalse("Check validEmail() method.", UserService.validPassword("Awfdw9ageahzjke"));


        assertTrue("Check validEmail() method.", UserService.validPassword("Awfdw9"));
        assertTrue("Check validEmail() method.", UserService.validPassword("adMin98"));

        validUser.forEach(u -> assertTrue("Check validEmail() method.", UserService.validPassword(u.getPassword())));
    }

    @Test
    public void hashTest() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String password = "ADdmin12345";
        String hashPassword = UserService.generateStrongPasswordHash(password);

        assertTrue("Check validatePassword() method.", UserService.validatePassword(password, hashPassword));
    }

    @After
    public void end() {
        validUser.clear();
    }
}
