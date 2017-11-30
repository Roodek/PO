
import java.io.*;
import java.util.Scanner;

public class LIczby_pierwsze {

    public static int getNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("podaj liczbe calkowita");
        int liczba = in.nextInt();

        return liczba;
    }

    public static void ZnajdzPierwsze(int max){
        int i=2;

        while ( i < max){
            boolean t=true;
            for(int j=2; j < i; j++ ){
                if(i%j==0){
                    t=false;
                    break;
                }
            }
            if(t) {
                System.out.println(i);
            }


            i++;
        }

    }
}
