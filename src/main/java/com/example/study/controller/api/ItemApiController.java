package com.example.study.controller.api;

import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Override
  @PostMapping("")  // api/time
  public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  @GetMapping("{id}") // api/time /1 ... 1000
  public Header<ItemApiResponse> read(@PathVariable Long id) {
    return null;
  }

  @Override
  @PutMapping("") // api/time
  public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  @DeleteMapping("{id}")  // api/time/1...1000
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
