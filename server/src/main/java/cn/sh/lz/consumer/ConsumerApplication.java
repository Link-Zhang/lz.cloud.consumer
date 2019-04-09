package cn.sh.lz.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Link at 16:17 on 4/4/19.
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {"cn.sh.lz.producer.clients", "cn.sh.lz.consumer.clients"})
@ComponentScan(basePackages = {"cn.sh.lz.producer", "cn.sh.lz.consumer"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
