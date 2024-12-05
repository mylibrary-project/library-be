package com.example.librarybe.book.controller;

import com.example.librarybe.book.data.dto.UserDTO;
import com.example.librarybe.book.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping("/id")
  public ResponseEntity<UserDTO> getUser(@RequestParam Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PostMapping("join")
  public ResponseEntity<String> joinUser(@RequestBody UserDTO userDTO) {
    String password = passwordEncoder.encode(userDTO.getPassword());
    userDTO.setPassword(password);
    userService.addUser(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body("가입성공");
  }

  @GetMapping("/admin")
  public ResponseEntity<String> admin() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = authentication.getAuthorities().stream()
        .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

    if(!isAdmin) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("관리자 권한이 필요합니다.");
    }
    return ResponseEntity.status(HttpStatus.OK).body("관리자입니다.");
  }
}
