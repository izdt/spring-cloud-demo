package com.abc.sc.consumerdemo.bean;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.shared.transport.TransportClientFactory;
import com.netflix.discovery.shared.transport.jersey.Jersey1TransportClientFactories;
import com.sun.jersey.api.client.filter.ClientFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.util.Collection;
import java.util.Optional;

@Component
public class AbcJersey1TransportClientFactories extends Jersey1TransportClientFactories {
    @Autowired(required = false)
    EurekaClientConfigInterceptor eurekaClientConfigInterceptor;
    @Autowired(required = false)
    InstanceInfoInterceptor instanceInfoInterceptor;
    @Autowired(required = false)
    ClientFilterInterceptor clientFilterInterceptor;
    @Override
    public TransportClientFactory newTransportClientFactory(final EurekaClientConfig clientConfig,
                                                            final Collection<ClientFilter> additionalFilters,
                                                            final InstanceInfo myInstanceInfo) {
        return newTransportClientFactory(clientConfig, additionalFilters, myInstanceInfo, Optional.empty(), Optional.empty());
    }

    @Override
    public TransportClientFactory newTransportClientFactory(EurekaClientConfig clientConfig,
                                                            Collection<ClientFilter> additionalFilters, InstanceInfo myInstanceInfo, Optional<SSLContext> sslContext,
                                                            Optional<HostnameVerifier> hostnameVerifier) {
        if(eurekaClientConfigInterceptor!=null) {
            eurekaClientConfigInterceptor.apply(clientConfig);
        }
        if(clientFilterInterceptor!=null){
            clientFilterInterceptor.apply(additionalFilters);
        }
        if(instanceInfoInterceptor!=null){
            instanceInfoInterceptor.apply(myInstanceInfo);
        }
        return super.newTransportClientFactory(clientConfig, additionalFilters, myInstanceInfo, sslContext, hostnameVerifier);
    }
}
