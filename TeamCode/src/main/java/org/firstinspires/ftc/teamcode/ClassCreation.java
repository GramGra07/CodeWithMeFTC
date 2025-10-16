package org.firstinspires.ftc.teamcode;

public class ClassCreation {
    static Car car = new Car();
    static Car toyotaCamry = new Car("Toyota","Camry",2021);
    static Car fordEscape = new Car("Ford","Escape",2022);

    // Class name = new ClassName();
    Double pi = 3.141592653;
    Learning learning = new Learning();
    Learning learning2 = new Learning();

    public static void main(String[] args) {
        String make = car.make;
        car.vroom();
        car.drive();
        car.honk();

        toyotaCamry.vroom();
        String tcMake = toyotaCamry.make;
    }
}

