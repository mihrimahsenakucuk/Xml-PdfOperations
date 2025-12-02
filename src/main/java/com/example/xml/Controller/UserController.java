package com.example.xml.Controller;

import com.example.xml.Model.User;
import com.example.xml.Service.UserService;
import com.example.xml.dto.CreateUserRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userDetails")
    public String userDetails() {
        return "userDetails";
    }

    @GetMapping("/userDelete")
    public String userDelete() {
        return "userDelete";
    }


    @PostMapping("/createUser")
    @ResponseBody
    public User createUser(@RequestBody CreateUserRequest createUserRequest){
        System.out.println("Controller çağrıldı!");
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        boolean deleted = userService.deleteUserIfExists(id);
        if (deleted) {
            return ResponseEntity.ok("User başarıyla silindi");
        } else {
            return ResponseEntity.ok("Belirtilen ID'de kullanıcı bulunamadı");
        }
    }








}
