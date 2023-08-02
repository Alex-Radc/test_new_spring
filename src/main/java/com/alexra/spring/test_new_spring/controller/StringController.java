package com.alexra.spring.test_new_spring.controller;

import com.alexra.spring.test_new_spring.entity.Str;
import com.alexra.spring.test_new_spring.entity.StringService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("v1/strings")
public class StringController {

    private final StringService stringService;


    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/list")
    public List<Str> list() {
        return stringService.list();
    }

    @PostMapping("/item")
    public void add(@RequestBody Str str){
        stringService.add(str);
    }

    @DeleteMapping("item/{strId}")
    public void delete(@PathVariable Long strId){
        stringService.delete(strId);
    }

    @PutMapping("item")
    public void update(@RequestBody Str str){
        stringService.update(str);
    }

}
