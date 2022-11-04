package com.xichuan.dev.controller;

import com.xichuan.dev.entity.XichuanTableEntity;
import com.xichuan.dev.service.XichuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Xichuan
 * @Date 2022/11/1 15:38
 * @Description
 */
@RestController
@RequestMapping("/lot_operation")
public class XichuanController {

    @Autowired
    XichuanService xichuanService;

    @GetMapping("/all_data")
    public List<XichuanTableEntity> getAllData(){
       return xichuanService.getAllData();
    }

}
