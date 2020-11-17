package com.example.study.repository;


import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;


@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("ItemRepositoryTest 테스트")
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void create(){

    Item item = new Item();
    item.setStatus("UNREGISTERED");
    item.setName("삼성 노트북");
    item.setTitle("삼성 노트북 A100");
    item.setContent("2019년형 노트북입니다.");
    item.setPrice(900000);
    item.setBrandName("삼성");
    item.setRegisteredAt(LocalDateTime.now());
    item.setCreatedAt(LocalDateTime.now());
    item.setCreatedBy("Partner01");
    item.setPartnerId(1L);

    Item newItem = itemRepository.save(item);
    Assertions.assertNotNull(newItem);
  }


  @Test
  public void read(){
    Long id = 1L;

    Optional<Item> item = itemRepository.findById(id);

    Assertions.assertTrue(item.isPresent());

//    item.ifPresent(i -> {
//      System.out.println(i);
//    });

  }
}