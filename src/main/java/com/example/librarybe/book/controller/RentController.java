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
  @PostMapping("/return/{rentId}")
  public ResponseEntity<RentDTO> returnBook(@PathVariable Long rentId) {
    RentDTO rentDTO = rentService.returnBook(rentId);
    return ResponseEntity.ok(rentDTO);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @PostMapping("/extend/{rentId}")
  public ResponseEntity<RentDTO> extendRental(@PathVariable Long rentId) {
    RentDTO rentDTO = rentService.extendRental(rentId);
    return ResponseEntity.ok(rentDTO);
  }

  @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<RentDTO>> getUserRentals(@PathVariable Long userId) {
    List<RentDTO> rentDTOs = rentService.getUserRentals(userId);
    return ResponseEntity.ok(rentDTOs);
  }
}
