package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.Rent;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentRepository extends JpaRepository<Rent, Long> {

  @Query("select r from Rent r left join fetch r.user where r.user.username = :username")
  List<Rent> findByUser_Id(String username);

  @Query("select r.id from Rent r where r.book.id = :bookId and r.endDate > current_date")
  Long findByRentIdFromBookId(Long bookId);
}
