package com.ibtech.microservices.servicejpa;

import com.ibtech.microservices.servicejpa.data.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CarService carService;

    @RequestMapping("/cars")
    public List<Car> listCars(@RequestParam String name){
        return carService.listCars(name);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }
}
