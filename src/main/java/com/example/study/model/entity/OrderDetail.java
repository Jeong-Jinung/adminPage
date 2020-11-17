package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
//@ToString(exclude = {"user", "item"}) // 연관관계 설정에 대해서는 exclude 시켜주는게 좋음
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  private LocalDateTime orderAt;

  private LocalDateTime arrivalDate;

  private String quantity;

  private BigDecimal totalPrice;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  // N : 1 -> order 기준으로 생각하기
//  @ManyToOne
//  private User user;

  // N : 1
//  @ManyToOne
//  private Item item;

}
