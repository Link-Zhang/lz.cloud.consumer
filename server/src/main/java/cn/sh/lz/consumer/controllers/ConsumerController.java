package cn.sh.lz.consumer.controllers;

import cn.sh.lz.consumer.entities.output.Greeting;
import cn.sh.lz.consumer.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Link at 14:15 on 4/9/19.
 */
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/hello")
    public Greeting hello() {
        return consumerService.hello();
    }

    @GetMapping("/world")
    public Greeting world() {
        return consumerService.world();
    }

    @GetMapping("/helloWorld")
    public Greeting helloWorld() {
        return consumerService.helloWorld();
    }
}
