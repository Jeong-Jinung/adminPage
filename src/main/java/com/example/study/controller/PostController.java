package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // 주소가 겹치는 것에 대한 것은 메소드에 대해서이다. 클래스는 겹쳐도 가능하다.
public class PostController {

  // HTML <form>
  // ajax 검색
  // http post body -> data
  // json, xml, multipart-form / test-plain


  @PostMapping(value = "/postMethod") // produces를 활용하여 데이터 타입을 지정해 줄 수 있다.
  public SearchParam postMethod(@RequestBody SearchParam searchParam) {
    return searchParam;
  }


  /*rest api 에서는 이렇게 사용하지는 않음 */
  @PutMapping("/putMethod")
  public void put() {

  }

  @PatchMapping("/patchMethod")
  public void patch() {

  }
}
