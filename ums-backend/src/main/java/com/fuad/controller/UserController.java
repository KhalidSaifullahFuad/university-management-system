package com.fuad.controller;

import com.fuad.entity.User;
import com.fuad.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {
    
    private final UserService userService;

    // Store a new User
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User User) {
        User newUser = userService.store(User);
        return ResponseEntity.ok(newUser);
    }

    // Update a User
    @PutMapping("/")
    public  ResponseEntity<User> update(@RequestBody User User) {
        User updateUser = userService.update(User);
        return ResponseEntity.ok(updateUser);
    }

    // Fetch a User by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        User User = userService.getById(id);
        return ResponseEntity.ok(User);
    }

    // Fetch all Users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> Users = userService.getAll();
        return ResponseEntity.ok(Users);
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
