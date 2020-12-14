package com.example.study.service;

import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res> {

  @Autowired(required = false)
  protected JpaRepository<Entity, Long> baseRepository;
}
