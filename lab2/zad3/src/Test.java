import java.util.List;
import java.util.Scanner;
import  java.util.ArrayList;

import pkg1.Punkt3D;

public class Test {
    private static List<Punkt3D>  punkty=new ArrayList<Punkt3D>();
    public static void main(String[] argv){

        int answer;
        Scanner read = new Scanner(System.in);
        boolean t=true;
        while(t){
            System.out.println("1.Wczytaj punkt 3D");
            System.out.println("2.Wyświetl wszystkie punkty");
            System.out.println("3.Oblicz odległość");
            System.out.println("4.Zakończ");
            answer = read.nextInt();
            /*if(answer>4 || answer<1){
                System.out.println("brak opcji");
                continue;
            }*/
            switch (answer){//jak ominac static ?? nvm dziala
                case 1:
                    loadIn();
                    System.out.println();
                    continue;
                case 2:
                    showAll();
                    System.out.println();
                    continue;
                case 3:
                    getDistance();
                    System.out.println();
                    continue;
                case 4: t=false;
                break;
                default: System.out.println("brak opcji");
                    continue;
            }
        }
    }

    private static void loadIn(){

        double x;
        double y;
        double z;
        Scanner read=new Scanner(System.in);
        System.out.println("podaj wspolrzedne");
        x=read.nextDouble();
        y=read.nextDouble();
        z=read.nextDouble();
        Punkt3D punkt=new Punkt3D(x,y,z);
        punkty.add(punkt);

    }
    private static void showAll(){
    int j = 1;
    for(Punkt3D i:punkty){
        System.out.println("punkt"+j);
        System.out.println(i.getX());
        System.out.println(i.getY());
        System.out.println(i.getZ());
        j++;
    }
    }
    private static void getDistance(){
        int punkt1;
        int punkt2;
        Scanner read=new Scanner(System.in);
        System.out.println("wybierz pierwszy punkt do obliczenia odleglosci:");
        punkt1=read.nextInt();
        if (punkt1>punkty.size()) {
            System.out.println("nie ma takiego punktu");
            return;
        }
        System.out.println("wybierz drugi punkt do obliczenia odleglosci:");
        punkt2=read.nextInt();
        if (punkt2>punkty.size()) {
            System.out.println("nie ma takiego punktu");
            return;
        }
        System.out.println("odleglosc wynosi");
        System.out.println(punkty.get(punkt1-1).distance(punkty.get(punkt2-1)));
    }


}
