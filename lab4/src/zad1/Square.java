package zad1;

public class Square extends Shape{
    public Square(double a,String Name){
        pole=a*a;
        name = Name;
    }

    @Override
    public void draw() {
        System.out.println(" ____");
        System.out.println("|    |");
        System.out.println("|____|");

    }
}
