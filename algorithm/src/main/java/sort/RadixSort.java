package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {23, 435, 15, 1120, 9, 5, 45, 56, 13211, 2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int maxVal = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        int len = (maxVal + "").length();
        int[][] bucketArr = new int[10][arr.length];
        int[] bucketCountArr = new int[10];

        int bucketNum = 0;
        for (int i = 1, n = 1; i <= len; i++, n *= 10) {
            //把数组中元素分散到各个桶中去
            for (int j = 0; j < arr.length; j++) {
                bucketNum = arr[j] / n % 10;
                bucketArr[bucketNum][bucketCountArr[bucketNum]] = arr[j];
                bucketCountArr[bucketNum] += 1;
            }
            //把桶里的元素放回原数组
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int m = 0; m < bucketCountArr[k]; m++) {
                    arr[index] = bucketArr[k][m];
                    index++;
                }
                bucketCountArr[k]=0;
            }
        }
    }
}
