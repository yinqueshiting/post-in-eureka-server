package com.example.postineurekaserver.service.impl;

import com.example.postineurekaserver.mapper.cluster.ClusterDataSourceMapper;
import com.example.postineurekaserver.service.ClusterDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClusterDataSourceServiceImpl implements ClusterDataSourceService {

    private final ClusterDataSourceMapper clusterDataSourceMapper;

    @Autowired
    public ClusterDataSourceServiceImpl(ClusterDataSourceMapper clusterDataSourceMapper) {
        this.clusterDataSourceMapper = clusterDataSourceMapper;
    }


    @Override
    public Object clusterTestData() throws Exception {
        return clusterDataSourceMapper.clusterTestData();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void clusterUpdateUserInfo(){
        clusterDataSourceMapper.clusterUpdateUserInfoByUserid(1006);
        int i = 5/0;
    }
}
