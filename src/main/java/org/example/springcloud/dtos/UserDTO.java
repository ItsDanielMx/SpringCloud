package org.example.springcloud.dtos;

public record UserDTO(String username,
                      String firstName,
                      String lastName,
                      int age,
                      String email) {
}