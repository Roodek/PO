import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends Shape{
    double sideA ;
    double sideB ;

    public Rect(double a, double b, String Name){
        sideA =a;
        sideB =b;
        pole=a*b;
        name = Name;
        width =(int)sideA;
        height = (int)sideB;

    }


    public void paint(GraphicsContext gc,int coordinateX,int coordinateY) {
        gc.setStroke(Color.BLUE);
        gc.fillRect(coordinateX,coordinateY,sideA,sideB);



    }



}
