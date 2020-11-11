package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor//기본 생성자
@Entity // ==table
//@Table(name = "user") // 클래스이름과 테이블 이름이 같으면 생략 가능하다.
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String account;

  private String email;

  private String phoneNumber;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // 1 : N
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderDetail> orderDetailList;
}
