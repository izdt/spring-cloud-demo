package com.abc.sc.providerdemo.services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.abc.sc.providerdemo.model.vo.SearchInfo;
import com.abc.sc.providerdemo.model.vo.UserInfo;
import com.abc.sc.providerdemo.model.vo.UserItem;

@Service
public class UserInfoService{
    public UserInfo getUserInfo(SearchInfo info){
        UserInfo userInfo = new UserInfo();
		userInfo.setId(info.getId()+1); 
		userInfo.setName("USER INFO:"+info.getName()); 
		ArrayList<UserItem> items = new ArrayList<UserItem>(); 
		items.add(new UserItem("18810100001","Address1")); 
		items.add(new UserItem("18810100002","Address2")); 
		userInfo.setItems(items);
        return userInfo;
    }
}