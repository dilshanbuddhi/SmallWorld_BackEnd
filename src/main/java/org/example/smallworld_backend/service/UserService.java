package org.example.smallworld_backend.service;


import org.example.smallworld_backend.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    void deleteUser(String email);
}