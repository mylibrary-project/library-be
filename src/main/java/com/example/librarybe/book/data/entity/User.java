package com.example.librarybe.book.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "birthday")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;

  @Size(max = 255)
  @Column(name = "username")
  private String username;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 255)
  @Column(name = "password")
  private String password;

  @Size(max = 11)
  @Column(name = "phone_number")
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  public enum UserRole {
    ADMIN,
    USER
  }

  @OneToMany(fetch= FetchType.LAZY, mappedBy = "user")
  private List<Rent> rentList = new ArrayList<>();

}