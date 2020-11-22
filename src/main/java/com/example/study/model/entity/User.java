package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor//기본 생성자
@Entity // ==table
//@Table(name = "user") // 클래스이름과 테이블 이름이 같으면 생략 가능하다.
@ToString(exclude = {"orderGroupList"})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String account;

  private String password;

  private String status;

  private String email;

  private String phoneNumber;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // User 1 : N OrderGroup
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<OrderGroup> orderGroupList;
}
