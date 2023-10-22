package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 8, 5, 9, 2};
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 冒牌排序的思路，每轮均找出最大值置于数组末尾
     * ★ 需要注意循环的边界，需要进行arr.length-1次的冒泡，每次冒泡对比的次数是比上一次少一次的，首次为arr.length-1次
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
