package zad1;

public class Triangle extends Shape {
    Triangle(double Area,String Name){
        pole = Area;
        name = Name;
    }

    public void draw(){
        System.out.println("     /|");
        System.out.println("    / |");
        System.out.println("   /  |");
        System.out.println("  /___|");
    }
}
