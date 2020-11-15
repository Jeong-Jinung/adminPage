package com.example.study.repository;

import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.SysexMessage;
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

  }

  @Test
  @Transactional
  public void read() {

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
