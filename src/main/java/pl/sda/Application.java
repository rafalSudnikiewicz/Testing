package pl.sda;

import pl.sda.entry.Calculator;

public class Application {
    public static void main(String[]args){
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        System.out.println(result);
    }
}
