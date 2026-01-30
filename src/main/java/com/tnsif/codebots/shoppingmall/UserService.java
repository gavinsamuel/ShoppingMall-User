package com.tnsif.codebots.shoppingmall;
import com.tnsif.codebots.shoppingmall.User;
import com.tnsif.codebots.shoppingmall.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        if(!repository.existsById(id)) {
            return null;
        }
        User user = repository.findById(id).get();
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return repository.save(user);

    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
