package com.bunny.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//@Controller
public class LoadBalanceController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

//    @LoadBalanced
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    @RequestMapping(path = "/rest/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String queryAnimal() {
        ServiceInstance instance = loadBalancer.choose("service-provider");
        System.out.println(instance.getUri());
        return restTemplate.getForObject(instance.getUri().toString() + "/rest/query", String.class);
    }
}
