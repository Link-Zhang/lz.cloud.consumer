package cn.sh.lz.consumer.services;

import cn.sh.lz.consumer.entities.output.Greeting;

public interface ConsumerService {
    Greeting hello();

    Greeting world();

    Greeting helloWorld();
}
