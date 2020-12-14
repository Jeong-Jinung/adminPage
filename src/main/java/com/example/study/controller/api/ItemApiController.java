package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.ItemRepository;
import com.example.study.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

  @Autowired
  private ItemApiLogicService itemApiLogicService;

  @PostConstruct
  public void init(){
    this.baseService = itemApiLogicService;
  }


}
