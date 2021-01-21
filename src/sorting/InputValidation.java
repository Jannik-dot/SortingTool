package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This class checks the passed String array for arguments and outputs messages if
 * the arguments are not of the correct Type.
 */
class InputValidation {

    public static boolean apply(String[] args, Map<String, String> map) {
        List<String> dataTypes = Arrays.asList("long", "word", "line");
        List<String> sortingTypes = Arrays.asList("natural", "byCount");

        if (args.length == 1) {
            if ("-dataType".equals(args[0])) {
                System.out.println("No data type defined!");
                return false;
            } else if ("-sortingType".equals(args[0])) {
                System.out.println("No sorting type defined!");
                return false;
            }
        } else {
            for (int i = 0, j = 1; i < args.length && j < args.length; i += 2, j += 2) {
                if (args[i].startsWith("-")
                        && !"-dataType".equals(args[i])
                        && !"-sortingType".equals(args[i])
                        && !"-inputFile".equals(args[i])
                        && !"-outputFile".equals(args[i])) {
                    System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", args[i]);
                }
                if ("-dataType".equals(args[i])) {
                    if (dataTypes.contains(args[j])) {
                        map.put("-dataType", args[j]);
                    } else {
                        System.out.println("No data type defined!");
                        return false;
                    }
                }
                if ("-sortingType".equals(args[i])) {
                    if (sortingTypes.contains(args[j])) {
                        map.put("-sortingType", args[j]);
                    } else {
                        System.out.println("No sorting type defined!");
                        return false;
                    }
                }
                if ("-inputFile".equals(args[i])) {
                    map.put("-inputFile", args[j]);
                }

                if ("-outputFile".equals(args[i])) {
                    map.put("-outputFile", args[j]);
                }
            }
        }

        if (map.isEmpty()) {
            System.out.println("No Arguments!");
        } else {
            return true;
        }

        return false;

    }
}
