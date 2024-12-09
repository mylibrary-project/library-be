package com.example.librarybe.book.controller;

import com.example.librarybe.book.data.dto.RentDTO;
import com.example.librarybe.book.service.RentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/rents")
@RequiredArgsConstructor
@RestController
public class RentController {

  private final RentService rentService;

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @PostMapping("/rent")
  public ResponseEntity<RentDTO> rentBook(
      @RequestParam Long bookId,
      @RequestParam String username
  ) {
    RentDTO rentDTO = rentService.rentBook(bookId, username);
    return ResponseEntity.ok(rentDTO);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @PostMapping("/return/{bookid}")
  public ResponseEntity<RentDTO> returnBook(@PathVariable Long bookid) {
    RentDTO rentDTO = rentService.returnBook(bookid);
    return ResponseEntity.ok(rentDTO);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @PostMapping("/extend")
  public ResponseEntity<RentDTO> extendRental(@RequestParam Long bookId) {
    RentDTO rentDTO = rentService.extendRental(bookId);
    return ResponseEntity.ok(rentDTO);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @GetMapping("/user")
  public ResponseEntity<List<RentDTO>> getUserRentals(@RequestParam String username) {
    List<RentDTO> rentDTOs = rentService.getUserRentals(username);
    return ResponseEntity.ok(rentDTOs);
  }
}
