package linkedlist;

import linkedlist.circlelist.BoyNode;

/**
 * @author Wierdz
 * @version 1.0
 */
public class test {
    public static void main(String[] args) {
        BoyNode boyNode1 = new BoyNode(0);
        BoyNode boyNode2 = new BoyNode(1);
        BoyNode bNode1 = null;
        BoyNode bNode2 = null;
        bNode1 = boyNode1;
        bNode1.setNext(boyNode2);
        boyNode2 = bNode2;

        System.out.println(bNode1.getNext());
    }
}
