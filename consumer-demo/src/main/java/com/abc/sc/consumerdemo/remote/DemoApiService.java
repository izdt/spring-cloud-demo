package com.abc.sc.consumerdemo.remote;

import com.abc.sc.consumerdemo.remote.vo.SearchInfo;
import com.abc.sc.consumerdemo.remote.vo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="spring-cloud-provider-demo")
public interface DemoApiService {
    @PostMapping("/v1/DEMOX001")
    public UserInfo getLastServiceInfo(@RequestBody SearchInfo request);
}