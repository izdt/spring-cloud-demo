package com.abc.sc.providerdemo.api;

import com.abc.sc.providerdemo.model.vo.SearchInfo;
import com.abc.sc.providerdemo.model.vo.UserInfo;
import com.abc.sc.providerdemo.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@Timed
class DemoController{
    @Autowired
	UserInfoService service;
	@PostMapping(path="/v1/DEMOX001")
	public UserInfo getLastServiceInfo(@RequestBody SearchInfo request){
		UserInfo userInfo = service.getUserInfo(request);
		return userInfo;
	}
}