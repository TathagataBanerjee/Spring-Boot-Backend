package com.BloodDonationApp.bloodDonationApp.controllers;

import com.BloodDonationApp.bloodDonationApp.models.User;
import com.BloodDonationApp.bloodDonationApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        User newUser = userService.registerNewUser(user);
        if(newUser == null){
            return ResponseEntity.ok()
                    .body("User with email address " + user.getEmailAddress() +
                            "already exists !!!!");
        }else{
            return ResponseEntity.ok()
                    .body("New User with User id :- " + user.getId() + " created !!");
        }
    }
}
