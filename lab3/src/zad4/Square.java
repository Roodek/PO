package zad4;

public class Square extends Shape{
    public Square(String Name){
        name=Name;
    }

    @Override
    public void draw() {
        System.out.println(" ____");
        System.out.println("|    |");
        System.out.println("|____|");

    }
}
