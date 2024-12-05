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
public class RentDTO {

  private Long id;
  private Long bookId;
  private Long userId;
  private LocalDate startDate;
  private LocalDate endDate;
  private boolean active;
  private int extensionCount;

}
