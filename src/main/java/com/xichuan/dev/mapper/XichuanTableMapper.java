package com.xichuan.dev.mapper;

import com.xichuan.dev.entity.XichuanTableEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xichuan
 * @Date 2022/11/1 15:30
 * @Description
 */
@Repository
public interface XichuanTableMapper {
    @Select("select id,start_time as startTime from test_xichuan_db.test_xichuan_table")
    List<XichuanTableEntity> getAllData();
}
