package com.abc.sc.consumerdemo.service;

import com.abc.sc.consumerdemo.remote.DemoApiService;
import com.abc.sc.consumerdemo.remote.vo.SearchInfo;
import com.abc.sc.consumerdemo.remote.vo.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService{
    @Autowired
    DemoApiService demoApiService;

    public UserInfo getUserInfo(String name){
        SearchInfo search = new SearchInfo();
        search.setId(1);
        search.setName(name);
        return demoApiService.getLastServiceInfo(search);
    }
}