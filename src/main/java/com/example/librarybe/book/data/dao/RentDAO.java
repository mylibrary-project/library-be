package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.Rent;
import java.util.List;

public interface RentDAO {

  Rent save(Rent rent);

  Rent getRentByBookId(Long bookId);

  Rent addRent(Rent rent);

  void deleteRentById(Long id);

  List<Rent> findByUser_Id(String username);
}
