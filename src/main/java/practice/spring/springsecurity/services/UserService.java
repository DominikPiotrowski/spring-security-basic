package practice.spring.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.spring.springsecurity.model.User;
import practice.spring.springsecurity.model.UserRole;
import practice.spring.springsecurity.repositories.UserRepo;
import practice.spring.springsecurity.repositories.UserRoleRepo;

@Service
public class UserService {

    private static final String ROLE_USER = "ROLE_USER";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    private UserRepo userRepo;
    private UserRoleRepo userRoleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUserWithDefaultRole(User user) {
        UserRole roleUser = userRoleRepo.findByRole(ROLE_USER);
        user.getRoles().add(roleUser);
        String passwordHash = passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordHash);
        userRepo.save(user);
    }
}