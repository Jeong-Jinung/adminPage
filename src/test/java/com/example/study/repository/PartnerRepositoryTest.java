package com.example.study.repository;

import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("PartnerRepository 테스트")
public class PartnerRepositoryTest {

  @Autowired
  private PartnerRepository partnerRepository;

  @Test
  public void create() {
    String name = "Partner01";
    String status = "REGISTERED";
    String address = "서울시 강남구";
    String callCenter = "070-1111-2222";
    String partnerNumber = "010-1111-2222";
    String businessNumber = "1234567890123";
    String ceoName = "홍길동";
    LocalDateTime registeredAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();
    String createdBy = "AdminServer";
    Long categoryId = 1L;

    Partner partner = new Partner();
    partner.setName(name);
    partner.setStatus(status);
    partner.setAddress(address);
    partner.setCallCenter(callCenter);
    partner.setPartnerNumber(partnerNumber);
    partner.setBusinessNumber(businessNumber);
    partner.setCeoName(ceoName);
    partner.setRegisteredAt(registeredAt);
    partner.setCreatedAt(createdAt);
    partner.setCreatedBy(createdBy);
    partner.setCategoryId(categoryId);

    Partner newPartner = partnerRepository.save(partner);
    Assertions.assertNotNull(newPartner); // null이 아니여야 한다.
    Assertions.assertEquals(newPartner.getName(), name); // 두개의 값을 비교
  }
}
