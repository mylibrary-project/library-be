package com.example.librarybe.book.data.repository;

import com.example.librarybe.book.data.entity.Rent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentRepository extends JpaRepository<Rent, Long> {

  @Query("select r from Rent r where r.user.id = :userId")
  List<Rent> findByUser_Id(Long userId);
}
