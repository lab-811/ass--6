package org.example.controller;

import org.example.entity.User;
import org.example.entity.UserData;
import org.example.repository.UserDataRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDataRepository userDataRepository;


    @GetMapping("")
    public List<User> getALLUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/{id}")
    public UserData updateUser(@PathVariable Long id, @RequestBody UserData userData){
        userData.setId(id);
        return  userDataRepository.saveAndFlush(userData);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);
    }

    @PostMapping("/userData")
    public UserData createUser(@RequestBody UserData userData){
        return userDataRepository.saveAndFlush(userData);
    }

    @PatchMapping("/{id}")
    public User updateUserAge(@PathVariable Long id,
                              @RequestParam String password) {
        User user = userRepository.findById(id).get();
        user.setPassword(password);

        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/userData/{id}")
    public void deleteUserData(@PathVariable Long id) {

        userDataRepository.deleteById(id);
    }


}
