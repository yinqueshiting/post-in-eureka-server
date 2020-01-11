package com.example.postineurekaserver.mapper.master;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface DataSourceMapper {
    public Map dataTest();

    void updateUserInfoByUserid(@Param("user_id") int i);

    void updateUserInfoByUserid2(@Param("user_id") int i);
}
