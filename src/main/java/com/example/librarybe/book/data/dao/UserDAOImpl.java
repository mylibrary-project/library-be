package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.User;
import com.example.librarybe.book.data.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDAOImpl implements UserDAO {

  private final UserRepository userRepository;

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public User getUserIdByUsername(String username) {
    Long userId = userRepository.findIdByUsername(username);
    return userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }
}
