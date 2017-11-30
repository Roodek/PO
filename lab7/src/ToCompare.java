

import java.util.Comparator;

public class ToCompare implements Comparator<Shape> {
    public int compare(Shape e1, Shape e2){
        if(e1.pole>e2.pole){
            return 1;
        }else {
            return -1;
        }
    }

}
