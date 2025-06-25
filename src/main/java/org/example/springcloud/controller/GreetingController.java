package org.example.springcloud.controller;


import org.example.springcloud.dtos.UserDTO;
import org.example.springcloud.mapper.UsuarioMapper;
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
    private final UsuarioMapper userMapper;

    public GreetingController(UserRepository userRepository, UsuarioMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public Mono<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);

        return userRepository.save(user)
                .map(userMapper::userToUserDTO);
    }
}
