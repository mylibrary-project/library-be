package com.example.librarybe.book.page;

import com.example.librarybe.book.data.dto.BookDTO;
import com.example.librarybe.book.data.entity.Book;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse {

  private List<BookDTO> content;
  private int pageNo;
  private int pageSize;
  private long totalElements;
  private int totalPages;
  private boolean last;
}
