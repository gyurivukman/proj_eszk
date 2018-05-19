package elte.projeszk.projeszk_receptek.service;

import elte.projeszk.projeszk_receptek.model.User;
import elte.projeszk.projeszk_receptek.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    private UserRepository userRepository;

    @Value("${jwt.key}")
    private String key;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        Optional<User> optional = userRepository.findByUsername(username);

        if (optional.isPresent()) {
                try {
                    User user = optional.get();
                    if (validatePassword(password, user.getPassword())) {
                        return Jwts.builder()
                                .setSubject(user.getUsername())
                                .claim("id", user.getId())
                                .signWith(SignatureAlgorithm.HS512, key)
                                .compact();
                    }
                } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            return null;
    }

    public Map<String, String> signUp(String username, String firstName, String lastName, String password, String email, boolean tos) {
        Map<String, String> map = new HashMap<>();

        if (!validUsername(username)) {
            map.put("userName", "Username must between 5 and 13 characters long and can only contain alphanumeric values.");
        } else if (userRepository.findByUsername(username).isPresent()) {
            map.put("username", "This username is already in use.");
        }
        if (!validName(firstName)) {
            map.put("firstName", "First name must between 3 and 13 characters long and can only contain letters.");
        }
        if (!validName(lastName)) {
            map.put("lastName", "Last name must between 3 and 13 characters long and can only contain letters.");
        }
        if (!validPassword(password)) {
            map.put("password", "Password must between 5 and 15 characters long , has to contain at least one uppercase letter and one number.");
        }
        if (!validEmail(email)) {
            map.put("email", "Email must be valid. (examples_1@examples.com)");
        } else if (userRepository.findByEmail(email).isPresent()) {
            map.put("email", "This email address is already in use.");
        }
        if (!tos) {
            map.put("tos", "Terms of Service must be accepted!");
        }
        if (map.isEmpty()) {
            try {
                String salt = generateStrongPasswordHash(username);
                User user = new User(username, firstName, lastName, email, generateStrongPasswordHash(password) + salt, salt, null, null, null);
                userRepository.save(user);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                System.out.printf("Error message: %s%n", e.getMessage());
            }
        }
        return map;
    }

    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    private static boolean validUsername(String username) {
        return username != null && username.matches("[a-zA-Z0-9]{5,13}");
    }

    private static boolean validName(String name) {
        return name != null && name.matches("[A-Z][a-zA-Zá-űÁ-Ű]{2,13}");
    }

    private static boolean validPassword(String password) {
        return password != null
                && password.length() > 5
                && password.length() < 15
                && Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$").matcher(password).matches();
    }

    private static boolean validEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return email != null
                && Pattern.compile(emailRegex).matcher(email).matches();
    }
}
