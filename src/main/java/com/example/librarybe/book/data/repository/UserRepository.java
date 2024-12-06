package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.User;
import jakarta.validation.constraints.Size;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u where u.username= :username")
  Optional<User> findByUsername(@Size(max = 255) String username);

  @Query("select u.id from User u where u.username= :username")
  Long findIdByUsername(String username);
}
