package sorting.processor;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class handles the input
 */
class Input {

    /**
     * Decides whether the input needs to be taken as line or word/"long"
     * @param dataType long/word/line
     * @param inputFile path to inputFile
     * @return
     */
    public static ArrayList<String> get(String dataType, String inputFile) {
        Scanner scanner = new Scanner(System.in);
        if (!"".equals(inputFile)) {
            try {
                File file = new File(inputFile);
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("There is no such file!");
            }
        }

        ArrayList<String> list = new ArrayList<>();
        if ("line".equals(dataType)) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } else {
            while (scanner.hasNext()) {
                list.addAll(Arrays.asList(scanner.nextLine().split("[\\s\\n]+")));
            }
        }
        scanner.close();
        return list;
    }
}
