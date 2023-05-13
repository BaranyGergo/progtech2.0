package com.example.progtech.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.progtech.Model.Car.Car;
import com.example.progtech.Patterns.Builder.CarBuilder;
import com.example.progtech.Patterns.Builder.Director;
import com.example.progtech.Repositroy.CarRepository;
import com.example.progtech.Service.CarService;




@RestController
@RequestMapping("/api")
public class CarController {

    Director director = new Director();

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    CarBuilder carBuilder = new CarBuilder();

   
    @GetMapping("/cars")
    public ModelAndView getAllCars() {
        ModelAndView mav = new ModelAndView("listcars");
        mav.addObject("cars", carRepository.findAll());
        return mav;
    }

   
   

  /*  @GetMapping("/cars")
   public ModelAndView showCars(){
    ModelAndView cars = new ModelAndView("listCars");
    List<Car> list = carRepository.findAll();
    cars.addObject("cars", list);
    return cars;

   }
*/
    @PostMapping("/addminibus")
    public RedirectView addMiniBus(){
        
        director.constructMinibusCar(carBuilder);
        Car car = carBuilder.getCar();
        carRepository.save(car);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
        
    }

    @PostMapping("/addhatchback")
    public RedirectView  addHatchback(){
        
        director.constructHatchbackCar(carBuilder);
        Car car = carBuilder.getCar();
        carRepository.save(car);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
    }
    
    
    @PostMapping("/addsportcar")
    public RedirectView addSportCar(){
        
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getCar();
        carRepository.save(car);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
    }

   @PostMapping("redupdate/{id}")
   public RedirectView redupdateCar(@PathVariable Long id){

        carService.updateRedCarColor(id);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
   }

   @PostMapping("yellowupdate/{id}")
   public RedirectView yellowupdateCar(@PathVariable Long id){

         carService.updateYellowCarColor(id);
         return  new RedirectView("http://127.0.0.1:8080/api/cars");
   }

   @PostMapping("blackupdate/{id}")
   public RedirectView blackupdateCar(@PathVariable Long id){

        carService.updateBlackCarColor(id);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
   }

   @PostMapping("whiteupdate/{id}")
   public RedirectView whiteupdateCar(@PathVariable Long id){

        carService.updateWhiteCarColor(id);
        return  new RedirectView("http://127.0.0.1:8080/api/cars");
   }

}


    