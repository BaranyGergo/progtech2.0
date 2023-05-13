package com.example.progtech.Patterns.Strategy;

import com.example.progtech.Model.Car.Car;
import com.example.progtech.Model.Car.Enums.Color;


public class ChangeCarColorStrategy  implements CarEditStrategy{

    private Color newCarColor;
   
    @Override
    public void edit(Car car) {
        car.setColor(newCarColor);
        
    }
    
    public ChangeCarColorStrategy(Color newCarColor) {
        this.newCarColor = newCarColor;
    }
}
