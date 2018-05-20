package elte.projeszk.projeszk_receptek;

import elte.projeszk.projeszk_receptek.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserTest {

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
    }
}
