package com.example.progtech;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.progtech.Model.Car.Car;
import com.example.progtech.Model.Car.Enums.Color;
import com.example.progtech.Model.Car.Enums.Type;
import com.example.progtech.Patterns.Builder.CarBuilder;
import com.example.progtech.Patterns.Builder.Director;
import com.example.progtech.Patterns.Strategy.ChangeCarColorStrategy;
import com.example.progtech.Repositroy.CarRepository;



@SpringBootTest
class ProgtechApplicationTests {

	@Autowired
    CarRepository carRepository;

	@Test
	public void testAddNew() {

		CarBuilder carBuilder = new CarBuilder();

        carBuilder.setCarColor(Color.Black);
        carBuilder.setCarSeats(6);
        carBuilder.setCarType(Type.Hatchback);
        Car car = carBuilder.getCar();
        Car savedCar = carRepository.save(car);

        Assertions.assertThat(savedCar).isNotNull();
		Assertions.assertThat(savedCar.getCarId()).isGreaterThan(0);

	}

	 @Test
	 public void testCarColorStrategy(){

		CarBuilder carBuilder = new CarBuilder();
		ChangeCarColorStrategy carRedColorStrategy = new ChangeCarColorStrategy(Color.Red);

		carBuilder.setCarColor(Color.Black);
        carBuilder.setCarSeats(6);
        carBuilder.setCarType(Type.Hatchback);
		Car car = carBuilder.getCar();
		carRedColorStrategy.edit(car);

		Car savedCar = carRepository.save(car);

		Assertions.assertThat(savedCar.getColor()).isEqualTo(Color.Red);

	 }

	@Test
    public void directorsMethodconstructHatchbackCar(){

		Director director = new Director();
		CarBuilder carBuilder = new CarBuilder();

		director.constructHatchbackCar(carBuilder);
		Car savedCar = carBuilder.getCar();
        carRepository.save(savedCar);

		Assertions.assertThat(savedCar.getSeats()).isEqualTo(4);
		Assertions.assertThat(savedCar.getColor()).isEqualTo(Color.Red);
		Assertions.assertThat(savedCar.getType()).isEqualTo(Type.Hatchback);
	}

}


    
    
