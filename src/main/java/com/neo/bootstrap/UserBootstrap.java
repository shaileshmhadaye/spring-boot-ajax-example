package com.neo.bootstrap;

import com.neo.jparepositories.UserRepository;
import com.neo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    public UserBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.save(getUsers());
        log.debug("inside bootstrap file!");
    }

    private List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setName("shailesh");
        user.setUsername("shailesh12");
        user.setEmail("shailesh@gmail.com");
        user.setPassword("password");
        user.setMobile("1234567896");
        user.setStatus("unmarried");

        users.add(user);

        User user1 = new User();
        user1.setName("raj");
        user1.setUsername("raj12");
        user1.setPassword("password");
        user1.setEmail("raj@gmail.com");
        user1.setMobile("2345729823");
        user1.setStatus("married");

        users.add(user1);

        return users;
    }
}
