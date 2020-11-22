package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderDetailList", "partner"})
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String status;

  private String name;

  private String title;

  private String content;

  private Integer price;

  private String brandName;

  private LocalDateTime registeredAt;

  private LocalDateTime unregisteredAt;

  private LocalDateTime createdAt;

  private String createdBy;

  private LocalDateTime updatedAt;

  private String updatedBy;

  //Item N : 1 Partner
  @ManyToOne
  private Partner partner;

  //Item 1 : N OrderDetail
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
  private List<OrderDetail> orderDetailList;


  // 1 : N
  // LAZY = 지연로딩, EAGER = 즉시로딩

  // LAZY = select * from item where id = ?
  // EAGER = 1:1 관계에 추천천
  // item_id = order_detail.item_id
  // user_id = order_detail.user_id
//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//  private List<OrderDetail> orderDetailList;

}
