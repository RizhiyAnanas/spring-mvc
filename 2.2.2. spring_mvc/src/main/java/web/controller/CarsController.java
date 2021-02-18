package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping("/cars")
    public String getTable(@RequestParam(value = "count", required = false, defaultValue = "5") int count, Model model){
        String[] brands = new String[]{"Subaru", "Lada", "Kia", "Ford", "Chevrolet"};
        String[] models = new String[]{"Impreza", "Vesta", "K5", "Mustang", "Camaro"};
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < count && i < 5; i++){
            cars.add(new Car(brands[i], models[i],"" + (i+1) + ""));
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}