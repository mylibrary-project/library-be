package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dto.RentDTO;
import com.example.librarybe.book.data.entity.Book;
import com.example.librarybe.book.data.entity.Rent;
import java.util.List;

public interface RentService {

  RentDTO rentBook(Long bookId, String username);

  RentDTO returnBook(Long rentId);

  RentDTO extendRental(Long rentId);

  List<RentDTO> getUserRentals(Long userId);

  default RentDTO toDTO(Rent rent) {
    return RentDTO.builder()
        .id(rent.getId())
        .bookId(rent.getBook().getId())
        .userId(rent.getUser().getId())
        .startDate(rent.getStartDate())
        .endDate(rent.getEndDate())
        .extensionCount(rent.getExtensionCount())
        .build();
  }

}
