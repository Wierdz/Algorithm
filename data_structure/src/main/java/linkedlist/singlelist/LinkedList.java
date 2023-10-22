package linkedlist.singlelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class LinkedList {
    public HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {

        HeroNode tNode = head;

        while (tNode.next != null) {
//            if (tNode.next == null) {
//                break;
//            }
            tNode = tNode.next;
        }
        tNode.next = heroNode;
    }

    public void addSort(HeroNode heroNode) {

        HeroNode tNode = head;

        //用于判断heroNode是否需要插入到链表中去
        boolean flag = false;

        while (tNode.next != null) {
            if (tNode.next.no == heroNode.no) {
                flag = true;
                break;
            } else if (tNode.next.no > heroNode.no) {
                break;
            }
            tNode = tNode.next;
        }

        if (flag) {
            tNode.next.name = heroNode.name;
            tNode.next.nickName = heroNode.nickName;
            System.out.println("该编号HeroNode已存在，不能添加" + heroNode.no + "，已更新");
        } else {
            heroNode.next = tNode.next;
            tNode.next = heroNode;
        }
    }

    public void del(int no) {
        HeroNode tNode = head;
        boolean flag = false;

        while (tNode.next != null) {
            if (tNode.next.no == no) {
                flag = true;
                break;
            }
            tNode = tNode.next;
        }
        if (flag) {
            tNode.next = tNode.next.next;
            System.out.println("编号为" + no + "的节点已删除");
        } else {
            System.out.printf("不存在编号为%d的节点\n", no);
        }

    }

    public void list() {
        HeroNode tNode = head;
        while (tNode.next != null) {
            tNode = tNode.next;
            System.out.println(tNode);
        }
    }


}
