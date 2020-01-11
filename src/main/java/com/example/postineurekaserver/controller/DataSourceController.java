package com.example.postineurekaserver.controller;

import com.example.postineurekaserver.service.DataSourceService;
import com.example.postineurekaserver.service.impl.ClusterDataSourceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    private final ClusterDataSourceServiceImpl clusterDataSourceService;

    @Autowired
    public DataSourceController(ClusterDataSourceServiceImpl clusterDataSourceService) {
        this.clusterDataSourceService = clusterDataSourceService;
    }

    @RequestMapping("/testData")
    public Object testData(){

        try {
            log.info("??");
          return  dataSourceService.testData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/testDataCluster")
    public Object testDataCluster(){

        try {
            log.info("?!!?");
            return  clusterDataSourceService.clusterTestData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
        多数据源的事务控制 有@掉用没有@ 回滚
     */
    @RequestMapping("/doubleSourceTran")
    public Object doubleSourceTran(){
        try {
            return dataSourceService.doubleSourceTran();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }  /*
        多数据源的事务控制 没有Tran调用有@Tran  不回滚
     */
    @RequestMapping("/masterUpdateUser")
    public Object masterUpdateUser(){
        try {
            return dataSourceService.masterUpdateUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
