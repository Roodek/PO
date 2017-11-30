package zad1;

public class Rect extends Shape{
    double sideA ;
    double sideB ;

    public Rect(double a, double b, String Name){
        double sideA =a;
        double sideB =b;
        pole=a*b;
        name = Name;
    }

    @Override
    public void draw() {
        for(int i=0; i < (int)this.sideA ;i++){
            System.out.print("*");
        }
        //for itd...
        System.out.println(" ________________");
        System.out.println("|                |");
        System.out.println("|________________|");
    }
}
