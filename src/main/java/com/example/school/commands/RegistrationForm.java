package com.example.school.commands;

import com.example.school.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class RegistrationForm {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String confirm;
    @NotBlank(message = "Your name is required")
    private String fullname;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, new Date());
    }
}
