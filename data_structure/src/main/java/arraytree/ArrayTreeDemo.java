package arraytree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class ArrayTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayTree aTree = new ArrayTree(arr);
        aTree.preList(0);
    }
}
