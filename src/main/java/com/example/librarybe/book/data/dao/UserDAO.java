package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.User;
import com.example.librarybe.book.data.entity.User.UserRole;
import java.util.Optional;

public interface UserDAO {

  User getUser(Long id);

  User addUser(User user);

  Optional<User> findByUsername(String username);

  User getUserIdByUsername(String username);
}
