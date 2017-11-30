import java.awt.*;

public class Square extends Shape{
        int side;
    public Square(double a,int side,String Name){
        pole=a*a;
        name = Name;
        this.side =side;
    }

    @Override
    public void draw(Graphics object) {


            Graphics g = object;
            g.drawRect(0,0,side,side);


    }

}
