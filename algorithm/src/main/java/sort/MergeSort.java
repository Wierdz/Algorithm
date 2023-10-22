package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
//        int arr[] = {1,2,3,7,9,4,6,8,11};
        int[] arr = {23, 35, 15, 20, 9, 5, 45, 56, 11, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序：分治思想
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }
    //分
    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, end);
        }
    }
    //合
    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int rStart = mid + 1;
        int lStart = start;
        int[] tempArr = new int[end - start + 1];
        int i = 0;

        while (lStart <= mid && rStart <= end) {
            while (lStart <= mid && arr[lStart] <= arr[rStart]) {
                tempArr[i] = arr[lStart];
                lStart++;
                i++;
            }
            while (rStart <= end && arr[lStart] > arr[rStart]){
                tempArr[i] = arr[rStart];
                rStart++;
                i++;
            }
        }
        if (lStart <= mid) {
            for (int j = lStart; j <=mid ; j++) {
                tempArr[i] = arr[j];
                i++;
            }
        }
        if (rStart <= end) {
            for (int j = rStart; j <= end; j++) {
                tempArr[i] = arr[j];
                i++;
            }
        }
        for (int j = 0; j < tempArr.length; j++) {
            arr[start+j] = tempArr[j];
        }
    }
}
