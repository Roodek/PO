

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Shape{
    LinkedList<Shape> shapes = new LinkedList<Shape>();
    public static void main(String[] args){

    launch(args);

    }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        LinkedList<Shape> shapes = new LinkedList<Shape>();
        int answer;
        int side;
        double sideA;
        double sideB;
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

                    if(shape.equals("square")){
                        System.out.println("what side?");
                        side = Area.nextInt();
                        shapes.add(new Square(side,shape));
                    }
                    if(shape.equals("rect")){
                        System.out.println("what sideA?");
                        sideA = Area.nextDouble();
                        System.out.println("what sideB?");
                        sideB = Area.nextDouble();
                       // System.out.println(sideA+" "+sideB);
                        shapes.add(new Rect(sideA,sideB,shape));
                    }

                    System.out.println();
                    continue;

                case 2://drawing images

                    int coordinateX = 0;
                    int coordinateY = 0;
                    for(Shape i:shapes){
                        i.paint(gc,coordinateX,coordinateY);
                        coordinateX+=i.width+10;
                        System.out.println(coordinateX);
                        if(coordinateX >= 500){
                            coordinateY +=200;
                            coordinateX = 0;

                        }
                    }
                    root.getChildren().add(canvas);
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                    System.out.println();

                    continue;



                case 3:
                    sort(shapes);
                    continue;
                case 4:
                    loop=false;
                    //primaryStage.close();

                    continue;


                default: System.out.println("brak opcji");
                    continue;
            }


        }
        System.out.println("koniec");


    }

    private static void sort(LinkedList<Shape> lista){
        Collections.sort(lista, new ToCompare());

    }
}