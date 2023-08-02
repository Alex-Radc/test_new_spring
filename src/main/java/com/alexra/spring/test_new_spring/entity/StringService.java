package com.alexra.spring.test_new_spring.entity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StringService {

   private final StringRepository stringRepository;

   public StringService(StringRepository stringRepository) {
      this.stringRepository = stringRepository;
   }

   public List<Str> list(){
      return stringRepository.findAll();
   }

   public void add(Str str) {
      stringRepository.save(str);
   }


   public void delete(Long strId) {
      stringRepository.deleteById(strId);
   }

   public void update(Str str) {
      Optional<Str> row = stringRepository.findById(str.getId());
      if(row.isPresent()){
         Str item = row.get();
         if(!str.getStr().isEmpty()){
            item.setStr(str.getStr());
         }
         stringRepository.save(item);
      }
   }
}
