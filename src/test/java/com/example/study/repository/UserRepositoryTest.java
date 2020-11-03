package com.example.study.repository;

import com.example.study.model.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest  // JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("ItemRepositoryTest 테스트")
public class UserRepositoryTest {

  //Dependency Injection (DI)
  @Autowired
  private UserRepository userRepository;

  @Test
  public void create(){
    // String sql = insert into user (%s, %d, %d) value (account, email, age);
    User user = new User();
    user.setAccount("TestUser03");
    user.setEmail("TestUser03@gmail.com");
    user.setPhoneNumber("010-3333-3333");
    user.setCreatedAt(LocalDateTime.now());
    user.setCreatedBy("TestUser03");

    User newUser = userRepository.save(user);
    System.out.println("newUser : " + newUser);
  }

  public void read() {

  }

  public void update() {

  }

  public void delete() {

  }

}
