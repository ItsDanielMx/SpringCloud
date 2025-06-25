package org.example.springcloud.controller;


import com.google.cloud.Timestamp;
import lombok.RequiredArgsConstructor;
import org.example.springcloud.dtos.UserDTO;
import org.example.springcloud.model.User;
import org.example.springcloud.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    private final UserRepository userRepository;

    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/greetings")
    public Mono<String> helloWorld() {
        return Mono.just("Hello World!");
    }

    @GetMapping("/user")
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public Mono<User> createUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
                .map(user -> User.builder()
                        .username(user.username())
                        .firstName(user.firstName())
                        .lastName(user.lastName())
                        .age(user.age())
                        .email(user.email())
                        .createdAt(Timestamp.now())
                        .build())
                .flatMap(userRepository::save);

    }
}