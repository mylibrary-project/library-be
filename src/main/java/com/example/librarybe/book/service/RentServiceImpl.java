package com.example.librarybe.book.service;

import com.example.librarybe.book.data.dao.BookDAO;
import com.example.librarybe.book.data.dao.RentDAO;
import com.example.librarybe.book.data.dao.UserDAO;
import com.example.librarybe.book.data.dto.RentDTO;
import com.example.librarybe.book.data.entity.Book;
import com.example.librarybe.book.data.entity.Rent;
import com.example.librarybe.book.data.entity.User;
import com.example.librarybe.book.data.repository.BookRepository;
import com.example.librarybe.book.data.repository.RentRepository;
import com.example.librarybe.book.exception.BookAlreadyRentedException;
import com.example.librarybe.book.exception.MaxExtensionLimitReachedException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class RentServiceImpl implements RentService {

  private final RentDAO rentDAO;
  private final BookDAO bookDAO;
  private final UserDAO userDAO;

  private static final int MAX_EXTENSION_LIMIT = 2;
  private static final int RENTAL_PERIOD_DAYS = 7;
  private static final int EXTENSION_PERIOD_DAYS = 7;

  @Transactional
  public RentDTO rentBook(Long bookId, Long userId) {
    Book book = bookDAO.getBook(bookId);

    if(book.isRented()) {
      throw new BookAlreadyRentedException("Book is already rented");
    }

    User user = userDAO.getUser(userId);

    Rent rent = Rent.builder()
        .book(book)
        .user(user)
        .startDate(LocalDate.now())
        .endDate(LocalDate.now().plusDays(RENTAL_PERIOD_DAYS))
        .build();

    Rent savedRent = rentDAO.addRent(rent);

    return toDTO(savedRent);
  }

  @Transactional
  public RentDTO returnBook(Long rentId) {
    Rent rent = rentDAO.getRentById(rentId);

    Book book = rent.getBook();
    book.setRented(false);
    bookDAO.addBook(book);

    rentDAO.deleteRentById(rent.getId());

    return toDTO(rent);
  }

  @Transactional
  public RentDTO extendRental(Long rentId) {
    Rent rent = rentDAO.getRentById(rentId);

    if(rent.getExtensionCount() >= MAX_EXTENSION_LIMIT) {
      throw new MaxExtensionLimitReachedException("Maximum extension limit reached");
    }

    rent.setEndDate(rent.getEndDate().plusDays(EXTENSION_PERIOD_DAYS));
    rent.setExtensionCount(rent.getExtensionCount() + 1);

    Rent updatedRent = rentDAO.save(rent);
    return toDTO(updatedRent);
  }

  public List<RentDTO> getUserRentals(Long userId) {
    List<Rent> userRentals = rentDAO.findByUser_Id(userId);
    return userRentals.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

}
