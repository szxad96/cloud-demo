package com.szx.comsumer.web;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.szx.comsumer.client.UserClient;
import com.szx.comsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "queryByIdFallBack")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    UserClient userClient;
    /**
     * 并不知道对方的路径,利用feign
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);

    }
    //    @Autowired
//    private RibbonLoadBalancerClient client;

    /**
     * 模拟熔断
     * @param id
     * @return
     */
//    @GetMapping("{id}")
////    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
////    @HystrixCommand
//    public String queryById(@PathVariable("id") Long id) {
//        if (id % 2 == 0){
//            throw new RuntimeException("");
//        }
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    public String queryByIdFallBack() {
//        return "不好意思";
//    }
    /**
     * 模拟负载均衡Ribbon
     */
//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id){
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance instance = instances.get(0);
////        ServiceInstance instance = client.choose("user-service");
////        String url = "http://" + instance.getHost() + ":" + instance.getPort()+ "/user/" + id;
//        String url = "http://user-service/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }


}
