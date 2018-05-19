package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",  method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
            String jwt = userService.login(username, password);
            if (jwt != null)
                return ResponseEntity.ok(jwt);
            else return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
