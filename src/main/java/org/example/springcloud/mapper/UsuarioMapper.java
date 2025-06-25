package org.example.springcloud.mapper;

import org.example.springcloud.dtos.UserDTO;
import org.example.springcloud.model.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    User userDTOToUser(UserDTO userDTO);

    // Entity → DTO
    UserDTO userToUserDTO(User user);
}
