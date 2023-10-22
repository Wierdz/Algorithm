package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {23, 35, 15, 20, 9, 5, 45, 56, 11, 2};
        int[] arr = {4, 6, 8, 5, 9, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * 快排的思想：递归
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int first = start;
        int last = end;

        while (first < last) {
            while (first < last && arr[last] >= pivot) {
                last--;
            }
            arr[first] = arr[last];
            while (first < last && arr[first] <= pivot) {
                first++;
            }
            arr[last] = arr[first];
        }
        arr[first] = pivot;
        if (first - 1 > start) {
            quickSort(arr, start, first - 1);
        }
        if (first + 1 < end) {
            quickSort(arr, first + 1, end);
        }
    }
}
