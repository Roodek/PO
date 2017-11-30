package zad1;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    LinkedList<Shape> shapes = new LinkedList<Shape>();
    public static void main(String[] argv){
        LinkedList<Shape> shapes = new LinkedList<Shape>();
        int answer;
        double area;
        String shape;
        Scanner read = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        Scanner Area = new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("1.add Shape");
            System.out.println("2.show Shape");
            System.out.println("3.sort");
            System.out.println("4.close");
            answer = read.nextInt();
            switch (answer){//jak ominac static ?? nvm dziala
                case 1:
                    System.out.println("what shape? :");
                    shape=scn.nextLine();
                    System.out.println("what area?");
                    area = Area.nextDouble();
                    if(shape.equals("square")){
                        shapes.add(new Square(area));
                    }
                    if(shape.equals("rectangle")){
                        shapes.add(new Rect(area));
                    }

                    System.out.println();
                    continue;

                case 2:
                    for(Shape i:shapes){
                        System.out.println(i.pole);
                        //i.draw();
                    }
                    System.out.println();
                    continue;
                case 3:
                    sort(shapes);
                    continue;
                case 4:
                    loop=false;
                    continue;


                default: System.out.println("brak opcji");
                    continue;
            }


        }
    }



    private static void sort(LinkedList<Shape> lista){
        Collections.sort(lista, new ToCompare());

    }
}
