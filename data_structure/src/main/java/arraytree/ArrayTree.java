package arraytree;

/**
 * 顺序存储二叉树的特点如下：
 * 1.顺序存储二叉树通常只考虑完全二叉树
 * 2.第 index(数组下标) 个元素的左子结点为 2 * index + 1
 * 3.第 index(数组下标) 个元素的右子结点为 2 * index + 2
 * 4.第 index(数组下标) 个元素的父结点为 (index - 1) / 2 ★ (偶数-1)/2 = (偶数-2)/2
 * @author Wierdz
 * @version 1.0
 */
public class ArrayTree {
    public int[] arr;

    public ArrayTree(int[] arr) {
        this.arr = arr;
    }

    //1. 前序遍历
    public void preList(int index) {
        //空值校验
        if (arr == null || arr.length == 0) {
            System.out.println("该顺序存储二叉树为空");
            return;
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preList(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preList(2 * index + 2);
        }
    }

}
