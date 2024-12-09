package com.example.librarybe.book.data.dao;

import com.example.librarybe.book.data.entity.Rent;
import com.example.librarybe.book.data.repository.RentRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RentDAOImpl implements RentDAO {

  private final RentRepository rentRepository;

  @Override
  public Rent save(Rent rent) {
    return rentRepository.save(rent);
  }

  @Override
  public Rent getRentByBookId(Long bookId) {
    Long rentId = rentRepository.findByRentIdFromBookId(bookId);
    return rentRepository.findById(rentId)
        .orElseThrow(() -> new RuntimeException("Rent not found"));

  }

  @Override
  public Rent addRent(Rent rent) {
    return rentRepository.save(rent);
  }

  @Override
  public void deleteRentById(Long id) {
    rentRepository.deleteById(id);
  }

  @Override
  public List<Rent> findByUser_Id(String username) {
    return rentRepository.findByUser_Id(username);
  }
}
