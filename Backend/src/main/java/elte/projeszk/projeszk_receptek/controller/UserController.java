package elte.projeszk.projeszk_receptek.controller;

import elte.projeszk.projeszk_receptek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
            String jwt = userService.login(body.get("username"), body.get("password"));
            if (jwt != null) {
                Map<String, String> resBody = new HashMap<>();
                resBody.put("token",jwt);
                return ResponseEntity.ok(resBody);
            }
            else return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody Map<String, String> body) {

        Map<String, String> map = userService.signUp(body.get("username"), body.get("firstName"), body.get("lastName"),
                body.get("password"), body.get("email"), Boolean.parseBoolean(body.get("tos")));
        if (map.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(map);
    }
}
