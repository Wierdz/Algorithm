package binarytree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class FishTree {
    public FishNode root;

    //1. 3种遍历方式
    public void preList() {
        if (root == null) {
            System.out.println("the tree root is empty!!");
            return;
        }
        root.preList();
    }

    public FishNode preSearch(int no) {
        if (root == null) {
            System.out.println("the tree root is empty!!");
            return null;
        }
        FishNode res = root.preSearch(no);
        return res;
    }
}
