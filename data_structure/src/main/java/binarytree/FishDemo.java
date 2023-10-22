package binarytree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class FishDemo {
    public static void main(String[] args) {
        FishTree fTree = new FishTree();

        FishNode fish1 = new FishNode(1, "tuna");
        FishNode fish2 = new FishNode(2, "salmon");
        FishNode fish3 = new FishNode(3, "eel");
        FishNode fish4 = new FishNode(4, "trout");

        fTree.root = fish2;
        fish2.setLeft(fish1);
        fish2.setRight(fish3);
        fish3.setRight(fish4);

        System.out.println("前序遍历开始~");
        fTree.preList();

        System.out.println("查找编号no:3的🐟~");
        System.out.println(fTree.preSearch(3));

    }
}
