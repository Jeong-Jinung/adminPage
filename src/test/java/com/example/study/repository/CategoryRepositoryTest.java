package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void create() {
    String type = "COMPUTER";
    String title = "컴퓨터";
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";

    Category category = new Category();
    category.setType(type);
    category.setTitle(title);
    category.setCreatedAt(createdAt);
    category.setCreatedBy(createdBy);

    Category newCategory = categoryRepository.save(category);

    Assertions.assertNotNull(newCategory);
    Assertions.assertEquals(newCategory.getType(), type);
    Assertions.assertEquals(newCategory.getTitle(), title);

  }

  @Test
  public void read() {

  }
}
