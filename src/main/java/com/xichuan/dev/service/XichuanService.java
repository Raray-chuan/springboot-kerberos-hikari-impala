package com.xichuan.dev.service;

import com.xichuan.dev.entity.XichuanTableEntity;
import com.xichuan.dev.mapper.XichuanTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Xichuan
 * @Date 2022/11/1 15:33
 * @Description
 */
@Service
public class XichuanService {

    @Autowired
    private XichuanTableMapper xichuanTableMapper;

    public List<XichuanTableEntity> getAllData(){
       return xichuanTableMapper.getAllData();
    }

}
