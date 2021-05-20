package com.peerlender.lendingengine;

import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LendingengineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(1,"John","Smith",27,"Plumber"));
        userRepository.save(new User(2,"Anna","Brown",53,"Designer"));
        userRepository.save(new User(3,"Larry","Blur",35,"Developer"));
        userRepository.save(new User(4,"Kelly","Chapel",19,"Student"));
    }
}
