package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, -1};
        shellSort2(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换法希尔排序
     *
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        //1. 分成多次插入排序
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //2. 每轮进行的操作是将每组的第n个和第n+gap个元素进行比较和交换
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        int tmp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //多组插入排序的第一轮、第二轮一次进行
            for (int i = gap; i < arr.length; i++) {
                tmp = arr[i];
                //for循环写法
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    if (tmp > arr[j]) {
//                        arr[j + gap] = tmp;
//                        break;
//                    }
//                    arr[j + gap] = arr[j];
//                    if (j <= gap) {
//                        arr[j] = tmp;
//                    }
//                }
                //while循环写法
                int j = i;
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && tmp < arr[j - gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = tmp;
                }
            }

        }
    }
}
