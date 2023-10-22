package linkedlist.doublelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class SnakeListDemo {
    public static void main(String[] args) {
        SnakeNode node1 = new SnakeNode(1, "银环蛇");
        SnakeNode node2 = new SnakeNode(2, "五步蛇");
        SnakeNode node3 = new SnakeNode(3, "眼镜蛇");
        SnakeNode node4 = new SnakeNode(4, "竹叶青");
        SnakeNode node5 = new SnakeNode(5, "莽山烙");

        SnakeList sList = new SnakeList();
        sList.addSort(node4);
        sList.addSort(node2);
        sList.addSort(node1);
        sList.addSort(node3);
        sList.addSort(node5);

        sList.list();
        SnakeNode node6 = new SnakeNode(5, "菜花蛇");
        sList.update(node6);
        System.out.println("更新no:5的节点---------");
        sList.list();
        sList.delete(1);
        System.out.println("已删除节点no:5--------");
        sList.list();
        SnakeNode node7 = new SnakeNode(1, "yinhuanshe");
        sList.add(node7);
        System.out.println("在结尾新增no:1节点");
        sList.list();
    }
}
