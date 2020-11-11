package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer price;

  private String content;

  // 1 : N
  // LAZY = 지연로딩, EAGER = 즉시로딩

  // LAZY = select * from item where id = ?
  // EAGER = 1:1 관계에 추천천
 // item_id = order_detail.item_id
  // user_id = order_detail.user_id
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
  private List<OrderDetail> orderDetailList;

}
