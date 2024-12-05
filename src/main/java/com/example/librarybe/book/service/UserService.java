package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dto.UserDTO;
import com.example.librarybe.book.data.entity.User;
import com.example.librarybe.book.data.entity.User.UserRole;

public interface UserService {

  UserDTO getUser(Long id);

  void addUser(UserDTO userDTO);

  default UserDTO toDTO(User user) {
    return UserDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .username(user.getUsername())
        .password(user.getPassword())
        .phoneNumber(user.getPhoneNumber())
        .birthday(user.getBirthday())
        .build();
  }

  default User toEntity(UserDTO userDTO) {
    return User.builder()
        .id(userDTO.getId())
        .name(userDTO.getName())
        .username(userDTO.getUsername())
        .password(userDTO.getPassword())
        .phoneNumber(userDTO.getPhoneNumber())
        .birthday(userDTO.getBirthday())
        .build();
  }
}
