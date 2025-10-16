package org.firstinspires.ftc.teamcode;

import java.util.List;
import java.util.Map;
enum Fruits{
    APPLE,
    BANANA,
    ORANGE,
    STRAWBERRY
}
public class Learning {
    public static Fruits fruit = Fruits.APPLE;

    static int in = 0;
    float out = 0.009098709817098720918374102398471209384701923874012938740192385091238650921384609123847102398740129387512039847f;
    double out2 = .975;
    String out3 = "Hello World!";
    static List<String> out4 = List.of("hello","world");
    static Map<Integer,String> out5 = Map.of(1,"hello",2,"world");

    private static double function(double aNumber){
        out4.get(0); //"hello"
        out5.get(1); //"hello"
        fruit = Fruits.BANANA;
        return in*aNumber;
    }
    public static void function2(){
        switch (fruit){
            case APPLE:
                System.out.println("Apple");
                break;
            case ORANGE:
                System.out.println("Orange");
                break;
            case STRAWBERRY:
                System.out.println("Strawberry");
                break;
            case BANANA:
                System.out.println("Banana");
        }

        Double b = function(0.6); // 0
        a = 1;
        String x = "B is equal to "+b.toString();
        // show string interpolation
        String y = String.format("B is equal to %.2f",b);
        String z = new String("B is equal to "+b);
        String easy = String.format("B is equal to %f",b);
    }
    public static int a = 0;
    private static final int thisIsAConstant = 745;

}