package sorting.processor.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class handles byCount sortingType
 */
public class SortByCount {

    /**
     * counts occurrences of elements in list and puts it into map
     * @param list list with elements
     * @return map with elements as key and their count as value
     */
    public static Map<String, Integer> apply(ArrayList<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String elements : list) {
            if (map.containsKey(elements)) {
                map.put(elements, map.get(elements) + 1);
            } else {
                map.put(elements, 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());
        map.clear();
        for (Map.Entry<String, Integer> entry : sortedList) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }
}
