package ru.netology.springbootdemo.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemo.domain.Authorities;
import ru.netology.springbootdemo.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    public static List<User> authorities;

    public UserRepository() {
        authorities = List.of(
                new User("admin", "12345", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)),
                new User("user1", "12345678", List.of(Authorities.READ)),
                new User("user2", "2222", List.of(Authorities.READ, Authorities.WRITE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        //Map<String, String> users = new ConcurrentHashMap<>();
        //users.put("admin", "12345");
        //users.put("user1", "12345678");

        for (User authority : authorities) {
            if (authority.name.equals(user)) {
                if (authority.password.equals(password)) {
                    list.addAll(authority.getAuthorities());
                } else {
                    return new ArrayList<>();
                }

            }

        }
        return list;
    }
}
