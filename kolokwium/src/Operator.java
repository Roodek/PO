import java.util.Stack;

public abstract class Operator  implements Obliczanie{
    String wartosc;

    public String getWartosc() {
        return wartosc;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        return 0;
    }
}
