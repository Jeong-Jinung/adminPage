package com.example.study.repository;

import com.example.study.model.entity.AdminUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("AdminUserRepositoryTest 테스트")
public class AdminUserRepositoryTest {

  @Autowired
  private AdminUserRepository adminUserRepository;

  @Test
  public void create() {
    AdminUser adminUser = new AdminUser();
    adminUser.setAccount("AdminUser01");
    adminUser.setPassword("adminUser01");
    adminUser.setStatus("REGISTERED");
    adminUser.setRole("PARTNER");
//    adminUser.setCreatedAt(LocalDateTime.now());
//    adminUser.setCreatedBy("AdminServer");
  }
}
