package com.abc.sc.consumerdemo.bean;

import com.sun.jersey.api.client.filter.ClientFilter;

import java.util.Collection;

public interface ClientFilterInterceptor {
    void apply(Collection<ClientFilter> filters);
}
