package com.example.study.repository;

import com.example.study.model.entity.User;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

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
    user.setAccount("TestUser01");
    user.setEmail("TestUser01@gmail.com");
    user.setPhoneNumber("010-3333-3333");
    user.setCreatedAt(LocalDateTime.now());
    user.setCreatedBy("TestUser01");

    User newUser = userRepository.save(user);
    System.out.println("newUser : " + newUser);
  }

  @Test
  public void read() {
    Optional<User> user = userRepository.findById(1L);

    user.ifPresent(selectUser -> { // 있으면
      System.out.println("user : " + selectUser);
      System.out.println("email : " + selectUser.getEmail());
    });
  }

  @Test
  public void update() {
    Optional<User> user = userRepository.findById(1L);

    user.ifPresent(selectUser -> { // 있으면
      selectUser.setAccount("PPPP");
      selectUser.setUpdatedAt(LocalDateTime.now());
      selectUser.setUpdatedBy("update method()");

    });

  }


  @Test
  public void delete(Long id) {

    Optional<User> user = userRepository.findById(1L);

    Assertions.assertTrue(user.isPresent()); // true

    user.ifPresent(selectuser -> {
      userRepository.delete(selectuser);
    });

    Optional<User> deleteUser = userRepository.findById(1L);

    Assertions.assertFalse(deleteUser.isPresent()); //false

  }

}
