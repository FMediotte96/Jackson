package api.jackson.controller;

import api.jackson.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CoffeeController {

    @GetMapping("/coffee")
    public Coffee getCoffee(
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String name
    ) {
        Coffee coffee = new Coffee();
        coffee.setBrand(brand);
        coffee.setDate(new Date());
        coffee.setName(name);

        return coffee;
    }
}
