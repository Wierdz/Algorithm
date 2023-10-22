package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 2};
        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移位法实现了插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp > arr[j]) {
                    arr[j + 1] = temp;
                    break;
                }

                arr[j + 1] = arr[j];
                if (j == 0) {
                    arr[j] = temp;
                }
            }
        }
    }
}
