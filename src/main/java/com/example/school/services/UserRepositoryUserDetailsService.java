package com.example.school.services;

import com.example.school.models.User;
import com.example.school.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserRepositoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("user '" + username + "' not found");
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            //throw new RuntimeException("User not found");
            return new User(null, null, null, null);
        }
        return user.get();
    }
}
