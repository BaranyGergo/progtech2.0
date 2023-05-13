package com.example.progtech.Model.Car;

import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Model.Car.Enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Car {
    
    @GeneratedValue
    @Id
    @Setter
    @Getter
    private Long carId;
    @Getter
    @Setter
    private Type type;
    @Getter
    @Setter
    private int seats;
    @Getter
    @Setter
    private Color color;

    public Car(Type type, int seats, Color color) {
        this.type = type;
        this.seats = seats;
        this.color = color;
    }

    public Car() {
       
    }

  

}
