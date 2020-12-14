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

    ItemApiRequest body = request.getData();
    itemRepository.findById(body.getId())
            .map(entityItem -> {
              entityItem
                      .setStatus(body.getStatus())
                      .setName(body.getName())
                      .setTitle(body.getTitle())
                      .setContent(body.getContent())
                      .setPrice(body.getPrice())
                      .setBrandName(body.getBrandName())
                      .setRegisteredAt(body.getRegisteredAt())
                      .setUnregisteredAt(body.getUnregisteredAt());

                      return entityItem;
            })
            .map(newEntityItem -> itemRepository.save(newEntityItem))
            .map(item -> response(item))
            .orElseGet(() -> Header.ERROR("데이터 없음"));


    return null;
  }

  @Override
  public Header delete(Long id) {
    
    //id 를 받아와서 삭제
    return itemRepository.findById(id)
            .map(item -> {
              itemRepository.delete(item);
              return Header.OK();
            })
            .orElseGet(() -> Header.ERROR("데이터 없음"));
  }


  private Header<ItemApiResponse> response(Item item) {

    String statusTitle = item.getStatus().getTitle();

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
