package com.ibtech.microservices.servicejpa.config;

import com.ibtech.microservices.servicejpa.data.Car;
import com.ibtech.microservices.servicejpa.data.CarRepository;
import com.ibtech.microservices.servicejpa.event.MessageReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfiguration {

    @Bean
    public InitializingBean seedDatabase(CarRepository repository) {
        return () -> {
            //repository.save(new Car("Honda", "Civic", 1997));
            //repository.save(new Car("Honda", "Accord", 2003));
            repository.save(new Car("Ford", "Escort", 1985));
        };
    }


    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter,
                                             @Qualifier("carCreated") Queue queue1,
                                             @Qualifier("carDeleted") Queue queue2,
                                             @Qualifier("carUpdated") Queue queue3) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(queue1, queue2, queue3);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver) {
        return new MessageListenerAdapter(messageReceiver, "receiveMessage");
    }
}
