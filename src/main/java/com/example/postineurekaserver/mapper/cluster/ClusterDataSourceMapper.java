package com.example.postineurekaserver.mapper.cluster;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ClusterDataSourceMapper {
    public Map clusterTestData();

    void clusterUpdateUserInfoByUserid(@Param("user_id") int i);
}
