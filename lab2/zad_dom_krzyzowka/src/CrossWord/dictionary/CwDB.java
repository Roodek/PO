package CrossWord.dictionary;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CwDB {
    private static final String FILENAME = "C:\\Users\\user\\Desktop\\PO";

    protected LinkedList<Entry> dict;


    public  CwDB(String filename){
        BufferedReader br=null;
        FileReader fr = null;
        try{
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public  void add(String word,String clue){

    }

    public Entry get(String word){

    }
    public  void remove(String word){

    }
    public void saveDB(String filename){

    }
    public int getSize(){

    }
    protected void createDB(String filename){

    }

}
