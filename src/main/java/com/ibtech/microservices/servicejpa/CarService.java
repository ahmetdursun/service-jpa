package com.ibtech.microservices.servicejpa;

import com.ibtech.microservices.servicejpa.data.Car;
import com.ibtech.microservices.servicejpa.data.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listCars(String name){
        List<Car> cars = new ArrayList<>();
        carRepository.findByMakeIgnoringCase(name).forEach(car -> {
            cars.add(car);
        });
        return cars;
    }
}
