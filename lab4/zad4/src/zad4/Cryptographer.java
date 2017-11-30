package zad4;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.Scanner;

public class Cryptographer {
   public static void cryptfile(String filename,String filename2,Algorithm algorithm){


       String line = null;

       try{
           FileReader fileReader = new FileReader(filename);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           PrintWriter zapis = new PrintWriter(filename2);

            while((line = bufferedReader.readLine()) != null){

                zapis.println(algorithm.crypt(line));
                zapis.close();

            }


       }catch(FileNotFoundException ex) {
           System.out.println(
                   "Unable to open file '" +
                           filename + "'");
       }
       catch(IOException ex) {
           System.out.println(
                   "Error reading file '"
                           + filename + "'");

       }

   }
    public static void decryptfile(String filename,String filename2,Algorithm algorithm){
        String line = null;

        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            PrintWriter zapis = new PrintWriter(filename2);

            while((line = bufferedReader.readLine()) != null){

                zapis.println(algorithm.decrypt(line));
                zapis.close();

            }


        }catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filename + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

}
