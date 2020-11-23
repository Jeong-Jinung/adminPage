package com.example.study.ifc;

import com.example.study.model.network.Header;

public interface CrudInterface {

  Header create();  // todo request object 추가

  Header read(Long id);

  Header update();

  Header delete(Long id);

}
