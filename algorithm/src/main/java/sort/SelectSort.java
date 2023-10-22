package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
//        int arr[] = {1,2,3,7,9,4,6,8,11};
        int[] arr = {23, 35, 15, 20, 9, 5, 45, 56, 11, 2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = minIndex(arr, i, arr.length - 1);
            swap(arr,i,min);
        }
    }

    private static int minIndex(int[] arr, int start, int end) {
        int minIndex = start;
        int minVal = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index1 > arr.length - 1 || index2 > arr.length - 1) {
            System.out.println("下标越界");
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
