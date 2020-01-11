package com.example.postineurekaserver.service;

import org.springframework.stereotype.Service;

public interface DataSourceService {
    Object testData()throws Exception;

    Object doubleSourceTran()throws Exception;

    Object masterUpdateUser() throws Exception;
}
