package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",  method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody Map<String, String> body) {
            String jwt = userService.login(body.get("username"), body.get("password"));
            if (jwt != null)
                return ResponseEntity.ok(jwt);
            else return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
