package linkedlist.doublelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class SnakeNode {
    public int no;
    public String name;

    public SnakeNode next;
    public SnakeNode pre;

    public SnakeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SnakeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
