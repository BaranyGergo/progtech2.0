package com.example.progtech.Patterns.Builder;

import com.example.progtech.Model.Car.Car;
import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Model.Car.Enums.Type;
public class CarBuilder implements Builder{

    private Color color;
    private Type type;
    private int seats;

    @Override
    public void setCarColor(Color color) {
        this.color = color;
        
    }

    @Override
    public void setCarSeats(int seats) {
        this.seats = seats;
        
    }

    @Override
    public void setCarType(Type type) {
        this.type = type;
        
    }

    public Car getCar(){
        return new Car(type, seats, color);
    }

    
    
}
