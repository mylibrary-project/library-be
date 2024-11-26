package com.example.librarybe.book.controller;

import com.example.librarybe.book.data.dto.CategoryDTO;
import com.example.librarybe.book.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories") // api/v1/books?category=
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getCategoryByName(@RequestParam(required = false) String name) {
    return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryBooks(name));
  }
}
