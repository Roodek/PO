package pkg1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {

    int rozmiarX =0;
    int rozmiarY =0;
    int [][] matrix;
    BufferedReader br = null;

    public Matrix(){}

    public Matrix(String file) throws IOException {
        String line = null;
        char array[]={};
        boolean linia = true;
        String number = new String();

        try {
            FileReader fileReader = new FileReader(file);
            //BufferedReader bufferedReader = new BufferedReader(fileReader);
            br = new BufferedReader(fileReader);
            while((line = br.readLine()) != null) {
                array = line.toCharArray();
                for (int i=0;i<array.length;i++){

                    if (linia==true && (int)array[i] == (int)',' ){
                        rozmiarY+=1;
                        continue;
                    }if (linia==true && (int)array[i] == (int)';' ){
                        rozmiarY+=1;
                    }
                   if(array[i]==';'){
                       rozmiarX+=1;
                       linia = false;
                       continue;
                   }
                }
                matrix = new int[rozmiarX][rozmiarY];

                int iterK = 0;
                int iterL = 0;
                for (int i=0;i<array.length;i++){
                    if (array[i]==',' || array[i]==';'){

                        matrix[iterL][iterK] = Integer.parseInt(number.substring(0, number.length()));

                        if(array[i] == ','){
                            iterK++;
                        }
                        if(array[i] == ';'){
                            iterL++;
                            iterK=0;
                        }
                        number = new String();
                        continue;
                    }
                    if (array[i]!=';' && array[i]!=',') {
                        number += array[i];
                    }
                }
            }

        }catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            file + "'");
        }catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + file + "'");
        }finally {
            br.close();

        }

    }

    public void closefile() throws IOException {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void create(){
        System.out.println("podaj rozmiar x:");
        Scanner in = new Scanner(System.in);
        rozmiarX = in.nextInt();
        System.out.println("podaj rozmiar y:");
        in = new Scanner(System.in);
        rozmiarY = in.nextInt();
        matrix = new int[rozmiarX][rozmiarY];

        System.out.println("podaj dane:");

        for(int i=0;i<rozmiarX;i++){
            for(int j=0;j<rozmiarY;j++) {
                in = new Scanner(System.in);
                matrix[i][j]=in.nextInt();
            }
        }
    }
    public void show(){
        for(int i=0;i<rozmiarX;i++){
            System.out.println();
            for(int j=0;j<rozmiarY;j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
    }

    public Matrix add(Matrix matrixAdd) throws MatrixDimensionsException {
        if (this.rozmiarX != matrixAdd.rozmiarX || this.rozmiarY != matrixAdd.rozmiarY){
            throw new MatrixDimensionsException();
            //System.out.println("macierze niezgodne");
            //return this;
        }
        Matrix result=new Matrix();
        result.rozmiarX=this.rozmiarX;
        result.rozmiarY=this.rozmiarY;
        result.matrix = new int[rozmiarX][rozmiarY];
        for(int i=0;i<result.rozmiarX;i++){
            for(int j=0;j<result.rozmiarY;j++) {
                result.matrix[i][j] = this.matrix[i][j]+matrixAdd.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix sub(Matrix matrixSub) throws MatrixDimensionsException {
        if (this.rozmiarX != matrixSub.rozmiarX || this.rozmiarY != matrixSub.rozmiarY){
            throw new MatrixDimensionsException();
        }
        Matrix result=new Matrix();
        result.rozmiarX=this.rozmiarX;
        result.rozmiarY=this.rozmiarY;
        result.matrix = new int[rozmiarX][rozmiarY];
        for(int i=0;i<result.rozmiarX;i++){
            for(int j=0;j<result.rozmiarY;j++) {
                result.matrix[i][j] = this.matrix[i][j]-matrixSub.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix mul(Matrix matrixMul) throws MatrixDimensionsException {
        if (this.rozmiarY != matrixMul.rozmiarX ){
            throw new MatrixDimensionsException();
        }
        int s=0;
        Matrix result=new Matrix();
        result.rozmiarX=this.rozmiarX;
        result.rozmiarY=matrixMul.rozmiarY;
        result.matrix = new int[rozmiarX][rozmiarY];
        for(int i=0;i<result.rozmiarX;i++){
            for(int j=0;j<result.rozmiarY;j++) {
                s=0;
                for(int k=0;k<matrixMul.rozmiarX;k++) {
                     s = s + (this.matrix[i][k] * matrixMul.matrix[k][j]);
                }
                result.matrix[i][j] = s;
            }
        }
        return result;
    }
}
