package cn.sh.lz.consumer.clients;

import cn.sh.lz.consumer.entities.output.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Link at 16:23 on 4/9/19.
 */
@FeignClient(name = "consumer", fallback = ConsumerClient.ConsumerClientFallBack.class)
public interface ConsumerClient {
    @GetMapping(value = "/hello")
    Greeting consumerHello();

    @GetMapping(value = "/world")
    String consumerWorld();

    @GetMapping(value = "/helloWorld")
    Greeting consumerHelloWorld();

    @Component
    static class ConsumerClientFallBack implements ConsumerClient {

        @Override
        public Greeting consumerHello() {
            return new Greeting(-1L, "服务降级!");
        }

        @Override
        public String consumerWorld() {
            return "服务降级!";
        }

        @Override
        public Greeting consumerHelloWorld() {
            return new Greeting(-1L, "服务降级!");
        }
    }
}
