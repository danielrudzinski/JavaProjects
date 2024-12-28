package pl.programowanie.springwebjpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(savedUser);


    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
         return userRepository.findById(id)
                 .map(ResponseEntity::ok)
                 .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
       return  userRepository.findById(id)
                .map(existingUser ->{
                    existingUser.setLogin(user.getLogin());
                    existingUser.setDisplayName(user.getDisplayName());
                    existingUser.setYearofbirth(user.getYearofbirth());

                    return userRepository.save(existingUser);
                })
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());

    }
    @PatchMapping("users/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Integer id, @RequestBody User user) {
        return  userRepository.findById(id)
                .map(existingUser ->{
                    if(user.getLogin()!=null) existingUser.setLogin(user.getLogin());
                    if(user.getDisplayName()!=null) existingUser.setDisplayName(user.getDisplayName());
                    if(user.getYearofbirth()!=null) existingUser.setYearofbirth(user.getYearofbirth());

                    return userRepository.save(existingUser);
                })
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if(!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}

