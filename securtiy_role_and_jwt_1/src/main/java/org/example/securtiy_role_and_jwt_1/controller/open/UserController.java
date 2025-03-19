package org.example.securtiy_role_and_jwt_1.controller.open;

import org.example.securtiy_role_and_jwt_1.model.User;
import org.example.securtiy_role_and_jwt_1.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // ------- Sign  Up ---------------
    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        userService.signUp(user);
        return "Account Created Successfully";
    }
}
