package lab6;
import io.indico.Indico;

import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] argv){


// single example

        Indico indico = null;
        try {
            indico = new Indico("5f72fbd4b516e8c96976b8033fac0515");
        } catch (IndicoException e) {
            e.printStackTrace();
        }

// batch example
        List<String> nazwy = new ArrayList<String>();

        File[] files = new File
                ("D:\\programowanie obiektowe\\lab6\\src\\lab6\\foto").listFiles();
        for(File file:files){
            if(file.isFile()){
                nazwy.add(file.getAbsolutePath());
            }
        }

        String[] example = new String[nazwy.size()];
        for(int i=0;i<nazwy.size();i++){
            example[i]=nazwy.get(i);
        }

        BatchIndicoResult multiple = null;
        try {
            multiple = indico.imageRecognition.predict(example);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        List<Map<String,Double>> results = null;
        try {
            results = multiple.getImageRecognition();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        Sortow helper = new Sortow();
        List<Map<String,Double>> sortResult = helper.sort(results);
        System.out.println(results.get(1));
        System.out.println(sortResult.get(1));



        //System.out.println(results);

    }
}
