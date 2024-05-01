package ru.netology.springbootdemo.repository;

import ru.netology.springbootdemo.domain.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        Map<String, String> users = new ConcurrentHashMap<>();
        users.put("admin", "12345");
        users.put("user1", "12345678");

        if (users.containsKey(user) && users.get(user).equals(password)){
            list.add(Authorities.WRITE);
            list.add(Authorities.READ);
            list.add(Authorities.DELETE);
        } else {
            return new ArrayList<>();
        }
        return list;
    }
}
