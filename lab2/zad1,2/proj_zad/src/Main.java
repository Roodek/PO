import pkg1.A;
import pkg1.B;

public class Main {
    public static void  main(String[] argv){

        A  nowy=new A(6,"brzydki kot z hiszpanii");
        B nowyB=new B(7,"ale on byl pakudny");

        nowy.callIncrement();
        nowyB.callDecrement();
        nowyB.callIncrement();//funkcja increment w B jest private - odpalany jest increment z klasy A-funkcja odziedziczona nie ma dostepu do private


    }
}
