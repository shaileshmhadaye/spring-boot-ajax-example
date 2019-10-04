package com.neo.services;

import com.neo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users;

    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    /*public List<User> findByUserNameOrEmail(String username, String email) {

        List<User> result = new ArrayList<User>();

        for (User user : users) {

            if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {

                if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                } else {
                    continue;
                }

            }
            if (!StringUtils.isEmpty(username)) {
                if (username.equals(user.getUsername())) {
                    result.add(user);
                    continue;
                }
            }

            if (!StringUtils.isEmpty(email)) {
                if (email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                }
            }

        }

        return result;

    }*/

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user2 = new User();
        user2.setName("shailesh");
        user2.setUsername("shailesh12");
        user2.setEmail("shailesh@gmail.com");
        user2.setPassword("password");
        user2.setMobile("1234567896");
        user2.setStatus("unmarried");

        users.add(user2);

        User user1 = new User();
        user1.setName("raj");
        user1.setUsername("raj12");
        user1.setPassword("raj12");
        user1.setEmail("raj@gmail.com");
        user1.setMobile("2345729823");
        user1.setStatus("married");

        users.add(user1);

    }

}
