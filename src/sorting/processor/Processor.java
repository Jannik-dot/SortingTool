package sorting.processor;

import sorting.processor.algorithms.SortByCount;

import java.util.ArrayList;

/**
 * Coordinates classes and input from main class
 */
public class Processor {

    /**
     *
     * @param dataType long/word/line
     * @param sortingType natural/byCount
     * @param inputFile path to inputFile
     * @param outputFile path to outputFile
     */
    public static void process(String dataType, String sortingType, String inputFile, String outputFile) {
        ArrayList<String> input = Input.get(dataType, inputFile);
        ArrayList<String> orderedElements = new ArrayList<>();
        int total;
        switch (dataType) {
            case "long":
                orderedElements = LongProcessor.process(input);
                break;

            case "word":
            case "line":
                orderedElements = StringProcessor.getSortedString(input);
                break;

            default:
                break;
        }

        if("natural".equals(sortingType)) {
            Printer.resultNatural(orderedElements, dataType, outputFile);
        } else if ("byCount".equals(sortingType)){
            total = orderedElements.size();
            Printer.resultCount(SortByCount.apply(orderedElements), total, dataType, outputFile);
        }
    }


}
