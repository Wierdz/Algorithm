package linkedlist.singlelist;

import java.util.Stack;

/**
 * @author Wierdz
 * @version 1.0
 */
public class LinkListDemo {
    public static void main(String[] args) {
        HeroNode hNode1 = new HeroNode(1, "宋  江", "及时雨");
        HeroNode hNode4 = new HeroNode(4, "林  冲", "豹子头");
        HeroNode hNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hNode3 = new HeroNode(3, "吴  用", "智多星");

        LinkedList list = new LinkedList();

//        list.add(hNode1);
//        list.add(hNode4);
//        list.add(hNode2);
//        list.add(hNode3);
        list.addSort(hNode1);
        list.addSort(hNode4);
        list.addSort(hNode2);
        list.addSort(hNode3);

        list.list();
        System.out.println("-----------------------------");

        reversePrint(list.head);

        System.out.println("-----------------------------");

        HeroNode hNode5 = new HeroNode(3, "吴  用", "智 星");
        list.addSort(hNode5);
        list.list();

        System.out.println("-----------------------------");

        list.del(3);
        list.del(5);
        list.list();

    }

    public static void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
    //两个有序链表相加 结果仍然是有序数组
    public static HeroNode addNode(HeroNode head1, HeroNode head2) {
        //判断是否为null
        if (head1.next == null) {
            return head2;
        }
        if (head2.next == null) {
            return head1;
        }
        HeroNode head = new HeroNode(-1, "", "");
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode newTail = null;

        while (cur1 != null && cur2 != null) {

            if (cur1.no <= cur2.no) {
                if (head.no == -1) {
                    head.next = cur1;
                    newTail = cur1;
                } else {
                    newTail.next = cur1;
                    newTail = newTail.next;
                }
                cur1 = cur1.next;
            } else {
                if (head.no == -1) {
                    head.next = cur2;
                    newTail = cur2;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                }
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            newTail.next = cur1;
        }
        if (cur2 != null) {
            newTail.next = cur2;
        }

        return head;
    }

    //1. 反向打印链表
    public static void reversePrint(HeroNode node) {
        if (node == null || node.next == null) {
            return;//
        }
        Stack<HeroNode> nodeStack = new Stack<>();
        HeroNode cur = node.next;

        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.next;
        }
        while (nodeStack.size() > 0) {
            HeroNode curNode = nodeStack.pop();
            System.out.print(curNode.toString() + '\t');
        }
        System.out.println();
    }
}
