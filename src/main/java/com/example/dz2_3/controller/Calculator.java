package com.example.dz2_3.controller;


import com.example.dz2_3.service.CalculatorServiceIml;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/calculator")
public class Calculator {

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }
    private final CalculatorServiceIml calculatorService;

    public Calculator(CalculatorServiceIml calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1,
                      @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam int num1,
                       @RequestParam int num2) {
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1,
                        @RequestParam int num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam int num1,
                           @RequestParam int num2) {
        if (num2 == 0) {
            return "На нуль делить нельзя!!!";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }
}
