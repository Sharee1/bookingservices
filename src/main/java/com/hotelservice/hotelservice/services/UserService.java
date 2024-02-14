package com.hotelservice.hotelservice.services;
import com.hotelservice.hotelservice.entity.Customer;
import com.hotelservice.hotelservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CustomerRepo userRepo;

    public Customer createUser(Customer user) {
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null.");
        }


        return userRepo.save(user);
    }

    public List<Customer> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<Customer> getUserById(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null.");
        }

        return userRepo.findById(userId);
    }

    public Customer updateUser(Integer userId, Customer updatedUser) {
        if (userId == null || updatedUser == null) {
            throw new IllegalArgumentException("User ID and updated user object cannot be null.");
        }

        Optional<Customer> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            Customer existingUser = optionalUser.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setId(updatedUser.getId());


            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }


    public void deleteUser(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null.");
        }

        userRepo.deleteById(userId);
    }
}