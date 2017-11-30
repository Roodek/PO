package pkg1;

public class B extends A {

    public B(int Number, String Name){
        super(Number,Name);
    }
    protected  void decrement(){
        number-=2;
        System.out.println(number);
    }
    void changeName(){}
    private void increment(){
        number+=2;
        System.out.println(number);
    }


}
