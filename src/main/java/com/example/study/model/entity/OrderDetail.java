package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
@ToString(exclude = {"orderGroup", "item"}) // 연관관계 설정에 대해서는 exclude 시켜주는게 좋음
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  private LocalDateTime arrivalDate;

  private int quantity;

  private BigDecimal totalPrice;

  @CreatedDate
  private LocalDateTime createdAt;

  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  @LastModifiedBy
  private String updatedBy;

  //OrderDetail N : 1 Item
  @ManyToOne
  private Item item;

  //OrderDetail N : 1 Ordergroup
  @ManyToOne
  private OrderGroup orderGroup;

  // N : 1 -> order 기준으로 생각하기
//  @ManyToOne
//  private User user;

  // N : 1
//  @ManyToOne
//  private Item item;

}
