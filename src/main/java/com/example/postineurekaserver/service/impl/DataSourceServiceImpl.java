package com.example.postineurekaserver.service.impl;

import com.example.postineurekaserver.mapper.cluster.ClusterDataSourceMapper;
import com.example.postineurekaserver.mapper.master.DataSourceMapper;
import com.example.postineurekaserver.service.DataSourceService;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
@Slf4j
public class DataSourceServiceImpl implements DataSourceService {


    @Autowired
    private DataSourceMapper dataSourceMapper;

    private final ClusterDataSourceMapper clusterDataSourceMapper;

    @Autowired
    public DataSourceServiceImpl(ClusterDataSourceMapper clusterDataSourceMapper, ClusterDataSourceServiceImpl clusterDataSourceService) {
        this.clusterDataSourceMapper = clusterDataSourceMapper;
        this.clusterDataSourceService = clusterDataSourceService;
    }

    private final ClusterDataSourceServiceImpl clusterDataSourceService;


    @Override
    public Object testData() throws Exception {
        return dataSourceMapper.dataTest();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Object doubleSourceTran() throws Exception {
        dataSourceMapper.updateUserInfoByUserid(1006);

       /* try{
            clusterDataSourceService.clusterUpdateUserInfo();
        }catch (Exception e){
            log.info("clust异常 但不能印象Master的执行");
            e.printStackTrace();
        }*/
        //masterUpdateUser();
        //int i = 5/0;
        return new HashMap();
    }

    //@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Object masterUpdateUser() throws Exception {
        dataSourceMapper.updateUserInfoByUserid2(1007);
        doubleSourceTran();
        int i = 5/0;
        return new HashMap<>();
    }

}
