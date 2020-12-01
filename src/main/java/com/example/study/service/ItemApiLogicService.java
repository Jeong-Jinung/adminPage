package com.example.study.service;

import com.example.study.ifc.CrudInterface;
import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.ItemRepository;
import com.example.study.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Autowired
  private PartnerRepository partnerRepository;

  @Autowired
  ItemRepository itemRepository;


  @Override
  public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

    ItemApiRequest body = request.getData();

    Item item = Item.builder()
            .status(body.getStatus())
            .name(body.getName())
            .title(body.getTitle())
            .price(body.getPrice())
            .brandName(body.getBrandName())
            .registeredAt(LocalDateTime.now())
            .partner(partnerRepository.getOne(body.getPartnerId()))
            .build();

    Item newItem = itemRepository.save(item);


    return null;
  }

  @Override
  public Header<ItemApiResponse> read(Long id) {
    return null;
  }

  @Override
  public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }


  private Header<ItemApiResponse> response(Item item) {

    ItemApiResponse body = ItemApiResponse.builder()
            .id(item.getId())
            .status(item.getStatus())
            .name(item.getName())
            .title(item.getTitle())
            .content(item.getContent())
            .price(item.getPrice())
            .brandName(item.getBrandName())
            .registeredAt(item.getRegisteredAt())
            .unregisteredAt(item.getUnregisteredAt())
            .partnerId(item.getPartner().getId())
            .build();

    return Header.OK(body);
  }


}
