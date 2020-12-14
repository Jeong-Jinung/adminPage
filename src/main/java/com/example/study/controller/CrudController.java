package com.example.study.controller;

import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<Req,Res> implements CrudInterface<Req,Res> {

  protected CrudInterface<Req,Res> baseService;

  @Override
  @PostMapping("")
  public Header<Res> create(@RequestBody Header<Req> request) {
    return baseService.create(request);
  }

  @Override
  @GetMapping("{id}")
  public Header<Res> read(@PathVariable Long id) {
    return baseService.read(id);
  }

  @Override
  @PutMapping("")
  public Header<Res> update(@RequestBody Header<Req> request) {
    return baseService.update(request);
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return baseService.delete(id);
  }
}
