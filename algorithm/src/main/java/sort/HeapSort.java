package sort;

import java.util.Arrays;

/**
 * @author Wierdz
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
//        adjustHeap(arr, 1, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;
        //第一个非叶子节点下标
        int startIndex = len / 2 - 1;
        for (int i = startIndex; i >= 0; i--) {
            adjustHeap(arr, i, len); //从最后一个非叶子结点开始向前逐个调整成大顶堆
        }
        for (int i = 1; i <= len - 1; i++) {
            //交换首尾元素后，将剩余数组元素重新调整成大顶堆，由于除开根结点均已是大顶堆，只需进行一次调整即可
            swap(arr, 0, len - i);
            adjustHeap(arr, 0, len - i);
        }
    }

    /**
     * 调整startIndex及其子结点为大顶堆
     * @param arr        待调整数组
     * @param startIndex 开始调整的非叶子结点下标
     * @param len        待调整数组长度
     */
    public static void adjustHeap(int[] arr, int startIndex, int len) {
        int temp = arr[startIndex];//临时变量存储当前节点的值

        for (int i = 2 * startIndex + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len && arr[i] < arr[i + 1]) {
                i++; //若左结点值<=右结点值 取大值
            }
            if (arr[i] > temp) { //大值与要调整的根结点值对比
                arr[startIndex] = arr[i]; //如果子结点大，则将子结点值赋予父节点
                startIndex = i;//父节点下标随之下移
            } else {
                break;//因为是从最后一个非叶子结点开始调整大顶堆的，已经部分构成大顶堆了
            }
        }
        arr[startIndex] = temp; //将temp值赋予最后的startIndex下标对应的位置
    }

    public static void swap(int[] arr, int index1, int index2) {
        if (index1 > arr.length - 1 || index2 > arr.length - 1) {
            System.out.println("下标越界");
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
