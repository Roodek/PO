

import java.util.*;

public class Sortow {

    public  List<Map<String,Double>> sort(List<Map<String,Double>> toSort){
        List<Map<String,Double>> wynik = new LinkedList<Map<String, Double>>();


        for(int i=0;i<toSort.size();i++){
            Map sortedMap = sortByValue(toSort.get(i));
            wynik.add(sortedMap);
        }


        return wynik;
    }

    public  Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }
    class ValueComparator implements Comparator {
        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            return valueB.compareTo(valueA);
        }
    }


}
