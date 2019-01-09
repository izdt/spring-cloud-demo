package com.abc.sc.consumerdemo.bean;


import com.netflix.appinfo.InstanceInfo;

public interface InstanceInfoInterceptor {
    void apply(InstanceInfo instanceInfo);
}
