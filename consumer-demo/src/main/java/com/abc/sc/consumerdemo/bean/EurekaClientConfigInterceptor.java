package com.abc.sc.consumerdemo.bean;

import com.netflix.discovery.EurekaClientConfig;

public interface EurekaClientConfigInterceptor {
    void apply(EurekaClientConfig config);
}
