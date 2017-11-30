package pkg1;
import java.util.Scanner;

public class A {
    protected int number;
    String name;

    public A(int Number, String Name){
        number=Number;
        name=Name;
    }
    public void callDecrement(){
        decrement();
    }
    public void callChangeName(){
        changeName();
    }
    public void  callIncrement(){
        increment();
    }
    private void increment(){
        number+=1;
        System.out.println(number);
    }
    protected void decrement(){
        number-=1;
        System.out.println(number);
    }
    void changeName(){
        System.out.println("podaj imie:");
        Scanner stream = new Scanner(System.in);
        name=stream.nextLine();
        System.out.println(name);
    }



}
