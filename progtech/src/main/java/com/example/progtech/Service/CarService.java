package com.example.progtech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progtech.Model.Car.Car;
import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Patterns.Strategy.ChangeCarColorStrategy;
import com.example.progtech.Repositroy.CarRepository;

@Service
public class CarService {

    ChangeCarColorStrategy carRedColorStrategy = new ChangeCarColorStrategy(Color.Red);
    ChangeCarColorStrategy carBlackColorStrategy = new ChangeCarColorStrategy(Color.Black);
    ChangeCarColorStrategy carWhiteColorStrategy = new ChangeCarColorStrategy(Color.White);
    ChangeCarColorStrategy carYellowColorStrategy = new ChangeCarColorStrategy(Color.Yellow);


    @Autowired
    CarRepository carRepository;


    public Car updateRedCarColor(Long carId){

        Car updateCar = carRepository.findById(carId).orElse(null);
        
        carRedColorStrategy.edit(updateCar);
        

        return carRepository.save(updateCar);
    }

    public Car updateYellowCarColor(Long carId){

        Car updateCar = carRepository.findById(carId).orElse(null);
        
        carYellowColorStrategy.edit(updateCar);
        

        return carRepository.save(updateCar);
    }

    public Car updateBlackCarColor(Long carId){

        Car updateCar = carRepository.findById(carId).orElse(null);
        
        carBlackColorStrategy.edit(updateCar);
        

        return carRepository.save(updateCar);
    }

    public Car updateWhiteCarColor(Long carId){

        Car updateCar = carRepository.findById(carId).orElse(null);
        
        carWhiteColorStrategy.edit(updateCar);
        

        return carRepository.save(updateCar);
    }

    public List<Car> listAllCars(){
        return carRepository.findAll();
    }

    
    
}
