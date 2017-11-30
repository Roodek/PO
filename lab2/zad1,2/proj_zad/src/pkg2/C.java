package pkg2;

import pkg1.B;//w innym pakiecie klasa musi zostac zaimportowana

public class C extends B {

    public C(int Number, String Name){
        super(Number,Name);
    }
    void changeName(){}

}