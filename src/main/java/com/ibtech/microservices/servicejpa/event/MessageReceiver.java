package com.ibtech.microservices.servicejpa.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibtech.microservices.servicejpa.data.Car;
import com.ibtech.microservices.servicejpa.data.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {


    @Autowired
    private CarRepository carRepository;

    public void receiveMessage(String message) {

        System.out.println("Received <" + message + ">");
        Car car = deserializeJson(message);
        carRepository.save(car);
    }


    private Car deserializeJson(String objectReceived) {
        ObjectMapper mapper = new ObjectMapper();
        Car car = null;

        try {
            car = mapper.readValue(objectReceived, Car.class);
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }

        System.out.println("Deserialized message payload: {}" + car);

        return car;
    }
}
