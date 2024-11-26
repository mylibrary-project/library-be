package com.example.librarybe.book.data.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

  private long id;
  private String name;
  private String email;
  private String password;
  private String phoneNumber;
  private Instant birthday;
  private boolean loggedIn;
}
