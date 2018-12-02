package pl.sda;

import pl.sda.advanced.FluentBuilder;

public class Application {
    public static void main(String[]args){
        FluentBuilder fb = new FluentBuilder();
        fb.setA(1)
          .setB(2)
          .setC(3);
    }
}
