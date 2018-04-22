package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.dao.UserDao;
import elte.projeszk.projeszk_receptek.exception.DataNotValidException;
import elte.projeszk.projeszk_receptek.exception.DuplicatedDataException;
import elte.projeszk.projeszk_receptek.exception.MissingDataException;
import elte.projeszk.projeszk_receptek.exception.UserNotValidException;
import elte.projeszk.projeszk_receptek.model.Comment;
import elte.projeszk.projeszk_receptek.model.Recipe;
import elte.projeszk.projeszk_receptek.model.User;
import elte.projeszk.projeszk_receptek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController implements ControllerInterface<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Override
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        try {
            userService.update(null);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
        } catch (DataNotValidException | MissingDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        try {
            userService.delete(user);
        } catch (DataNotValidException e) {
            e.printStackTrace();
        }
    }


    @Override
    @PostMapping("/create")
    public void create(@RequestBody User user) {
        try {
            userService.create(user);
        } catch (DuplicatedDataException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return userDao.getEntities();
    }

    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user, Model model) {
        try {
            userService.login(user);
            return ResponseEntity.ok(userService.getUser());
        }
        catch (UserNotValidException e) {
            model.addAttribute("error", true);
            return ResponseEntity.status(403).build();
        }
    }

    @RequestMapping("/logout")
    public ResponseEntity logout() {
        userService.setUser(null);
        return ResponseEntity.ok(false);
    }

    @GetMapping("/user")
    public ResponseEntity getUser() {
        if (userService.getUser() == null) {
            return ResponseEntity.ok(false);
        } else {
            return ResponseEntity.ok(userService.getUser());
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public  ResponseEntity<User> register(@RequestBody User user) {
        userService.register(user);

        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping("/addRecipe/{userId}")
    public void create(@PathVariable Integer userId, @RequestBody Recipe recipe) {
        userService.addRecipe(userId, recipe);
    }

    @PostMapping("/addComment/{userId}")
    public void create(@PathVariable Integer userId, @RequestBody Comment comment) {
        userService.addComment(userId, comment);
    }
}