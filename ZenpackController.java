package com.example.specification.controller;

import com.example.specification.dao.Zenpack;
import com.example.specification.dto.FilterDTO;
import com.example.specification.dto.ZenpackDTO;
import com.example.specification.dto.ZenpackFilterDTO;
import com.example.specification.service.ZenpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/specification")
public class ZenpackController {

    @Autowired
    ZenpackService zenpackService;

    @PostMapping("")
    public void create(@RequestBody ZenpackDTO zenpackDTO) {
        zenpackService.create(zenpackDTO);
    }

    @PostMapping("/list")
    public List<Zenpack> getList(@RequestBody ZenpackFilterDTO zenpackFilterDTO) {
        return zenpackService.getList(zenpackFilterDTO);
    }
}
