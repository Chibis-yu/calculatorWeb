package pro.sky.calculatorWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculatorWeb.service.CalculatorService;

@RestController
@RequestMapping("/Calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String showWelcome() {
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        int resultat = calculatorService.plus(num1, num2);
        return createResultat(num1, num2, '+', resultat);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        int resultat = calculatorService.minus(num1, num2);
        return createResultat(num1, num2, '-', resultat);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int resultat = calculatorService.multiply(num1, num2);
        return createResultat(num1, num2, '*', resultat);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "Деление на 0 невозможно";
        }
        int resultat = calculatorService.divide(num1, num2);
        return createResultat(num1, num2, '/', resultat);
    }
private String createResultat(int num1, int num2, char action, int summa) {
        return String.format("%d %c %d = %d", num1, action, num2, summa);
}
}
