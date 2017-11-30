import java.io.*;

public class PESEL {
   static String Pesel ;



    /*public static void fillPesel(String newPesel){
        Pesel=newPesel;
    }*/

    public static void fillPesel(){
        System.out.println("podaj pesel do sprawdzenia: ");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            Pesel = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}

    }

    public  int[] stringToArray(String text){
        int[] array = new int [text.length()];
        for(int i=0;i<text.length();i++){
            array[i]=text.charAt(i)-48;
        }
        return array;
    }

    public static boolean check(){
        PESEL pesel = new PESEL();
        int[] array = pesel.stringToArray(Pesel);
        if((9*array[0]+7*array[1]+3*array[2]+1*array[3]+9*array[4]+7*array[5]+3*array[6]+1*array[7]+9*array[8]+7*array[9])%10==array[10]){
            System.out.println("poprawny");
        }else
            System.out.println("niepoprawny");


        return true;
    }

}
