package com.example.progtech.Patterns.Builder;

import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Model.Car.Enums.Type;

public class Director {
    
    public void constructMinibusCar(CarBuilder carBuilder) {
        
        carBuilder.setCarColor(Color.Yellow);
        carBuilder.setCarSeats(6);
        carBuilder.setCarType(Type.Minibus);
    }

    public void constructHatchbackCar(CarBuilder carBuilder) {
        
        carBuilder.setCarColor(Color.Red);
        carBuilder.setCarSeats(4);
        carBuilder.setCarType(Type.Hatchback);
    }


    public void constructSportsCar(CarBuilder carBuilder) {
        
        carBuilder.setCarColor(Color.White);
        carBuilder.setCarSeats(2);
        carBuilder.setCarType(Type.Sport);
    }
    
}