package sorting.processor;

import java.util.ArrayList;

/**
 * Class handles word/line dataTypes
 */
class StringProcessor {

    /**
     * Sorts String Arraylist lexicographically
     * @param list To be sorted Strings
     * @return sorted Strings in ArrayList
     */
    static ArrayList<String> getSortedString(ArrayList<String> list) {
        list.sort(String::compareTo);
        return list;
    }



}
