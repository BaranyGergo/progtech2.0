package com.example.progtech.Patterns.Builder;

import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Model.Car.Enums.Type;

public interface Builder {
    
    public void setCarColor(Color color);
    public void setCarType(Type type);
    public void setCarSeats(int seats);

}
