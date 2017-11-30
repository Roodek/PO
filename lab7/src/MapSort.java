import java.util.*;
import java.util.*;

public class MapSort {


    public Map<String, Double> sort(Map<String, Double> toSort) {
        Map<String, Double> result2 = new LinkedHashMap<>();
        toSort.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        return result2;
    }
}

