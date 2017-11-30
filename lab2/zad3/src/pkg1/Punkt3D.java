package pkg1;

public class Punkt3D extends Punkt2D {
    private double z;

    public Punkt3D(double x, double y, double z){
        super(x,y);
        setZ(z);
    }

    public double getZ() {
        return z;
    }

    private void setZ(double z) {
        this.z = z;
    }


    public double distance(Punkt3D punkt) {
        return Math.sqrt((this.x-punkt.x)*(this.x-punkt.x)+(this.y-punkt.y)*(this.y-punkt.y)+(this.z-punkt.z)*(this.z-punkt.z));
    }
}
