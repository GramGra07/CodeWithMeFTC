package org.firstinspires.ftc.teamcode;

public class Car {
    String make;
    String model;
    int year;

    public Car(String make2, String model, int year){
        this.make = make2;
        this.model = model;
        this.year = year;
    }
    public Car(){
    }
    void vroom(){
        System.out.println("Vroom!");
    }
    void honk(){
        System.out.println("Beep beep!");
    }
    void drive(){
        System.out.println("Driving!");
    }
}