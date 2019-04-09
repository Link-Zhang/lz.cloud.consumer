package cn.sh.lz.consumer.services.impl;

import cn.sh.lz.consumer.entities.output.Greeting;
import cn.sh.lz.consumer.services.ConsumerService;
import cn.sh.lz.producer.clients.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Link at 14:06 on 4/9/19.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String serviceInstanceId;

    @Autowired
    private ProducerClient producerClient;

    private final AtomicLong counter = new AtomicLong();

    private static final String producerTemplate = "From Server: %s";

    private static final String consumerTemplate = "Hello, %s!";

    @Override
    public Greeting hello() {
        return new Greeting(counter.incrementAndGet(), String.format(consumerTemplate, serviceInstanceId));
    }

    @Override
    public Greeting world() {
        String msg = producerClient.productMsg();
        return new Greeting(counter.incrementAndGet(), String.format(producerTemplate, msg));
    }

    @Override
    public Greeting helloWorld() {
        cn.sh.lz.producer.entities.output.Greeting greeting = producerClient.productHello();
        return new Greeting(counter.incrementAndGet(), String.format(producerTemplate, greeting.getContent()));
    }
}
