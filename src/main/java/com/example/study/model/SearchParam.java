package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 변수를 갖는 생성자를 만들어 준다.
public class SearchParam {
  // { "account" : "", "email" : "", "page" : 0} -> JSON 형식

  private String account;
  private String email;
  private int page;



}
