import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class WeWy {
    public static Stack<Operator> pobierzDzialanie(){
        String outString = new String();
        Stack<Operator> dzialanie = new Stack<Operator>();
        try {
            Scanner in = new Scanner(new FileReader("C:\\Users\\user\\Desktop\\plik.txt"));
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                sb.append(in.next());
            }
            in.close();
            outString = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(outString);
        for(int i=0;i < outString.length();i++ ){
            Stała a = new Stała(String.valueOf(outString.charAt(i)));//wrzucanie na stos
            dzialanie.push(a);
        }
        String znak = dzialanie.peek().wartosc;
        Mnożenie m = new Mnożenie();
        Dzielenie d = new Dzielenie();
        Dodawanie dd = new Dodawanie();

        if(znak.equals("+")){
            dzialanie.pop();
            dd.oblicz(dzialanie);

        }
        else  if (znak.equals("*")){
            dzialanie.pop();
            m.oblicz(dzialanie);
        }
        else if(znak.equals("/")){
            dzialanie.pop();
            d.oblicz(dzialanie);
        }

        return dzialanie;
    }

}
