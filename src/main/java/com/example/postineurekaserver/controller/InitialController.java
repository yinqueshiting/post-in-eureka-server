package com.example.postineurekaserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用在初始化的简单请求
 * @create: 2019-12-12 17:55
 **/
@RestController
@Slf4j
public class InitialController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("initial")
    public Object initial(){
       log.info("discoveryClient.getOrder():{}",discoveryClient.getOrder());
       List<ServiceInstance> instanceList =  discoveryClient.getInstances("post-in-eureka-server-no1");
        for (ServiceInstance instanString:instanceList
        ) {
            log.info("url:{}",instanString.getUri());
            log.info("host:{}",instanString.getHost());
            log.info("port:{}",instanString.getPort());
            log.info("getServiceId:{}",instanString.getServiceId());
            log.info("getInstanceId:{}",instanString.getInstanceId());
        }
       List<String> serverList = discoveryClient.getServices();
        for (String serverString:serverList
             ) {
            log.info("serverString:{}",serverString);
        }
      // log.info("简单请求discoveryClient:{}",discoveryClient.ge);

        Map map = new HashMap<String,String>();
        map.put("every", "is ok");
        return map;
    }
    /**
     * @Description 测试被json类型的请求调用
     * @return
     * @Date 2019/12/17 16:07
     * @Created by xg
     */
    @PostMapping(value = "postJson")
    public Object postJson(@RequestBody Map paramMap){
        log.info("postJson接收参数：{}",paramMap);
        Map resMap = new HashMap<>();
        resMap.put("ok", "value");
        return resMap;
    }
    /**
     * @Description 测试被表单的请求调用
     * @return
     * @Date 2019/12/17 16:07
     * @Created by xg
     */
    @PostMapping(value = "postForm")
    public Object postForm(@RequestParam("key")String value){
        log.info("postForm接收的参数：{}",value);
        Map resMap = new HashMap<>();
        resMap.put("ok", "value");
        return resMap;
    }
}
