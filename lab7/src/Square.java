import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Square extends Shape{
        int side;
    public Square(double a,int side,String Name){
        pole=a*a;
        name = Name;
        this.side =side;

    }
    public Square(int side,String Name){
        this.side=side;
        this.name=Name;
        width=side;
        height = side;
    }


    public void paint(GraphicsContext gc,int coordinateX,int coordinateY) {

    gc.fillRect(coordinateX,coordinateY,(double)side,(double)side);



    }


}
