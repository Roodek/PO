package pkg1;


public class Punkt2D {
    protected double x;
    protected double y;
    public Punkt2D(double X, double Y){
        setX(X);
        setY(Y);
    }

    private void setX(double x) {
        this.x = x;
    }
    private   void setY(double y){
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Punkt2D punkt){
        return Math.sqrt((this.x-punkt.x)*(this.x-punkt.x)+(this.y-punkt.y)*(this.y-punkt.y));
    }
}
