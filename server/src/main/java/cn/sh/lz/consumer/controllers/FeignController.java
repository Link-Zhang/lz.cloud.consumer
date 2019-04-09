package cn.sh.lz.consumer.controllers;

import cn.sh.lz.consumer.clients.ConsumerClient;
import cn.sh.lz.consumer.entities.output.Greeting;
import cn.sh.lz.producer.clients.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Link at 16:54 on 4/9/19.
 */
@RequestMapping("/feign")
@RestController
public class FeignController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProducerClient producerClient;

    @Autowired
    private ConsumerClient consumerClient;

    @GetMapping(value = "/producer/instances")
    public List<ServiceInstance> producerInstances() {
        return discoveryClient.getInstances("producer");
    }

    @GetMapping(value = "/producer/hello")
    public cn.sh.lz.producer.entities.output.Greeting producerHello() {
        return producerClient.productHello();
    }

    @GetMapping(value = "/producer/msg")
    public String producerMsg() {
        return producerClient.productMsg();
    }

    @GetMapping(value = "/consumer/instances")
    public List<ServiceInstance> consumerInstances() {
        return discoveryClient.getInstances("consumer");
    }

    @GetMapping(value = "/consumer/hello")
    public Greeting consumerHello() {
        return consumerClient.consumerHello();
    }

    @GetMapping(value = "/consumer/world")
    public String consumerWorld() {
        return consumerClient.consumerWorld();
    }

    @GetMapping(value = "/consumer/helloWorld")
    public Greeting consumerHelloWorld() {
        return consumerClient.consumerHelloWorld();
    }
}
