package com.example.study.repository;

import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

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
    String account = "Test01";
    String password = "Test01";
    String status = "REGISTERED";
    String email = "Test01@gamil.com";
    String phoneNumber = "010-1111-2222";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";

    User user = new User();
    user.setAccount(account);
    user.setPassword(password);
    user.setStatus(status);
    user.setEmail(email);
    user.setPhoneNumber(phoneNumber);
    user.setRegisteredAt(registeredAt);
    user.setCreatedAt(createdAt);
    user.setCreatedBy(createdBy);

    User newUser = userRepository.save(user);

    Assertions.assertNotNull(newUser);
  }

  @Test
  @Transactional
  public void read() {
    User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

    Assertions.assertNotNull(user);

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
