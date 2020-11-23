package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api") // localhost:8080/api 까지 매핑
public class GetController {

  @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
  public String getRequest() {

    return "Hi getMethod";
  }

  @GetMapping("/getParameter")  // localhost:8080/api/getParameter?id=1234&password=abcd
  public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {

    String password = "bbbb";

    System.out.println("id : " + id);
    System.out.println("password : " + pwd);

    return id+pwd;
  }

  // localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10
  @GetMapping("/getMultiParameter")
  public SearchParam getMultiParameter(SearchParam searchParam) {
    System.out.println(searchParam.getAccount());
    System.out.println(searchParam.getEmail());
    System.out.println(searchParam.getPage());

    // { "account" : "", "email" : "", "page" : 0} -> JSON 형식
    return searchParam;
  }

  @GetMapping("/header")
  public Header getHeader(){
    // {"resultCode" : "OK", "description" : "OK"}
    return Header.builder().resultCode("OK").description("OK").build();
  }

}
