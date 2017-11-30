package zad4;

public class Rect extends Shape{
    public Rect(String Name){
        name=Name;
    }

    @Override
    public void draw() {
        System.out.println(" ________________");
        System.out.println("|                |");
        System.out.println("|________________|");
    }
}
