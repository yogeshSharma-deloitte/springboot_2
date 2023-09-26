package com.hashedin.migration.controllers;

import com.hashedin.migration.entity.User;
import com.hashedin.migration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author MstfDryl
 */

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService userService;

@GetMapping
public List<User> getAllUsers(){
return userService.getAllUsers();
}

@PutMapping("/{id}")
public User editUser(@PathVariable Long id, @RequestBody User user){
return userService.editUser(id, user);
}

@PostMapping
public User addUser(@RequestBody User user){
return userService.saveUser(user);
}

@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id){
userService.deleteUser(id);
}

}