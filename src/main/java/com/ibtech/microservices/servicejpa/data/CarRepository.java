package com.ibtech.microservices.servicejpa.data;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {

	Iterable<Car> findByMakeIgnoringCase(String make);

}
