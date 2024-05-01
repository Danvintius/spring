package ru.netology.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootdemo.exception.InvalidCredentials;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.domain.*;
import ru.netology.springbootdemo.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }

    public static class AuthorizationService {
        UserRepository userRepository;

        List<Authorities> getAuthorities(String user, String password) {
            if (isEmpty(user) || isEmpty(password)) {
                throw new InvalidCredentials("User name or password is empty");
            }
            List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
            if (isEmpty(userAuthorities)) {
                throw new UnauthorizedUser("Unknown user " + user);
            }
            return userAuthorities;
        }

        private boolean isEmpty(String str) {
            return str == null || str.isEmpty();
        }

        private boolean isEmpty(List<?> str) {
            return str == null || str.isEmpty();
        }
    }
}