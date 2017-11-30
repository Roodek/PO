package pkg1;

import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws IOException {
        Matrix A = new Matrix();
        Matrix B = new Matrix();
        Matrix C = new Matrix("C:\\Users\\user\\Desktop\\macierz.txt");
        Matrix D = new Matrix("C:\\Users\\user\\Desktop\\macierz2.txt");
        try {
            /*A.create();
            A.show();
            B.create();
            A.add(B);
            A.mul(B).show();*/
            D.add(C);
            C.show();
        }catch (MatrixDimensionsException e){
            return;
        }
    }
}
