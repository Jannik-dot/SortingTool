package sorting.processor;

import sorting.processor.algorithms.MergeSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class handles the long datatype.
 */
class LongProcessor {

    /**
     * Sorts a String Arraylist by transforming it into a Long Arraylist
     * and mergeSorting it
     * @param input String Arraylist with elements to be sorted
     * @return ordered Long Arraylist
     */
    public static ArrayList<String> process(ArrayList<String> input) {
        ArrayList<String> orderedElements = new ArrayList<>();
        long[] array = getLongInput(input);
        MergeSort.apply(array, 0, array.length);
        for (long numbers : array) {
            orderedElements.add(String.valueOf(numbers));
        }
        return orderedElements;
    }

    /**
     * Parses String Arraylist to Long Arraylist and filtering all elements
     * that are not of the type long in the process, while also informing the user
     * about it
     * @param input String Arraylist with elements that need sorting
     * @return returns Long arraylist
     */
    private static long[] getLongInput(ArrayList<String> input) {
        List<Long> list = new LinkedList<>();
        for (String longs : input) {
            try {
                long number = Long.parseLong(longs);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.printf("\"%s\" is not a long. It will be skipped.\n", longs);
            }
        }

        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }


}
