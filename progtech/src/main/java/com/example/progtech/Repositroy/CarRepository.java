package com.example.progtech.Repositroy;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.progtech.Model.Car.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
}
