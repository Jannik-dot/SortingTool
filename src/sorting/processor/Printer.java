package sorting.processor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Class handles the output
 */
class Printer {

    /**
     * Creates output String of ordered Elements
     * @param array ordered String Arraylist
     * @param inputType long/word/line
     * @param outputFile path for outputFile
     */
    public static void resultNatural(ArrayList<String> array, String inputType, String outputFile) {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Total %ss: %d.\n", inputType, array.size()));
        output.append("Sorted data: ");

        for (var elements: array) {
            if ("line".equals(inputType)) {
                output.append("\n").append(elements);
            } else {
                output.append(elements).append(" ");
            }
        }
        print(outputFile, output);

    }

    /**
     * Creates String for byCount sortingType
     * @param map contains element and count
     * @param total total of all elements
     * @param inputType long/word/line
     * @param outputFile path to outputFile
     */
    public static void resultCount(Map<String, Integer> map, int total, String inputType, String outputFile) {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Total %ss: %d.\n", inputType, total));
        for (String keys : map.keySet()) {
            double percentage = ((map.get(keys) / (float) total) * 100);
            output.append(String.format("%s: %d time(s), %.2f%%\n", keys, map.get(keys), percentage));
        }
        print(outputFile, output);
    }

    /**
     * Depending on if an outputFile has been declared it print the created String to
     * the console or to the file.
     * @param outputFile path to outputFile
     * @param output String that needs to be printed
     */
    private static void print(String outputFile, StringBuilder output) {
        if ("".equals(outputFile)) {
            System.out.println(output);
        } else {
            try {
                File file = new File(outputFile);
                if (file.createNewFile()) {
                    FileWriter writer = new FileWriter(file);
                    writer.write(output.toString());
                    writer.flush();
                } else {
                    System.out.println("Could not create file. File might already exist!");
                }
            } catch (IOException e) {
                System.out.println("Could not write to file. Check path!");
            }

        }
    }

}
