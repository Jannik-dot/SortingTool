package sorting;

import sorting.processor.Processor;

import java.util.*;

/**
 * This is the main Class where command line arguments are checked for validity
 * and then passed to the Processor class.
 * Valid arguments:
 * -dataType long/word/line
 * -sortingType natural/byCount
 * -inputFile anyName.txt
 * -outputFile anyName.txt
 */
public class Main {
    public static void main(final String[] args) {
        Map<String, String> map = new HashMap<>();

        if (InputValidation.apply(args, map)) {

            String dataType = map.getOrDefault("-dataType", "word");
            String sortingType = map.getOrDefault("-sortingType", "natural");
            //
            //
            String inputFile = "";
            String outputFile ="";
            if (map.containsKey("-inputFile")) {
                inputFile = "Sorting Tool\\task\\Data\\Input\\" + map.get("-inputFile");
            }
            if (map.containsKey("-outputFile")) {
                outputFile = "Sorting Tool\\task\\Data\\Output\\" + map.get("-outputFile");
            }

            Processor.process(dataType, sortingType, inputFile, outputFile);
        }


    }
}
