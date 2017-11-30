public class Main {
    public static void main(String[] args){
        Matrix A=new Matrix();
        Matrix B=new Matrix();

        A.create();
        A.show();
        B.create();
        A.mul(B).show();

    }
}
