package com.example.librarybe.book.data.dto;

import java.time.LocalDate;
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
  private String username;
  private String password;
  private String phoneNumber;
  private LocalDate birthday;
  private enum UserRole{
    ADMIN,
    USER
  };
}
