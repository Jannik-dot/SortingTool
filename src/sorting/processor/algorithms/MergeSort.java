package sorting.processor.algorithms;

public class MergeSort {

    /**
     * Method divides starting Array until it is sorted
     * @param array Array that needs sorting
     * @param left start index
     * @param right end index
     */
    public static void apply(long[] array, int left, int right) {
        if (right <= left + 1) {
            return;
        }

        int middle = left + (right - left) / 2;

        apply(array, left, middle);
        apply(array, middle, right);

        merge(array, left, middle, right);
    }


    private static void merge(long[] array, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;

        long[] temp = new long[right - left];

        while (i < middle  && j < right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        for (; i < middle; i++, k++) {
            temp[k] = array[i];
        }

        for (; j < right; j++, k++) {
            temp[k] = array[j];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

}
