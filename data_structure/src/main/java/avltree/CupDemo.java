package avltree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class CupDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 11, 7, 6, 8, 9};
        CupTree cTree = new CupTree();

        for (int i = 0; i < arr.length; i++) {
            cTree.addCup(new CupNode(arr[i]));
        }
        cTree.infixOrder();
        System.out.println("左旋之前");
        System.out.printf("二叉树的高度为%d\n", cTree.root.height());
        System.out.printf("左子树高度为%d\n", cTree.root.leftHeight());
        System.out.printf("右子树高度为%d\n", cTree.root.rightHeight());
    }
}
