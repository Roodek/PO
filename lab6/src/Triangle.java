import java.awt.*;

public class Triangle extends Shape {
    Triangle(double Area,String Name){
        pole = Area;
        name = Name;
    }

    public void draw(Graphics object){
        System.out.println("     /|");
        System.out.println("    / |");
        System.out.println("   /  |");
        System.out.println("  /___|");
    }


    //public void paint() {

    //}
}
