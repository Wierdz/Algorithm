package linkedlist.doublelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class SnakeList {
    public SnakeNode head = new SnakeNode(-1, "");

    // 遍历链表
    public void list() {
        SnakeNode temp = head.next;
        if (temp == null) {
            System.out.println("链表为空！");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }

    //在链表尾部新增节点
    public void add(SnakeNode sNode) {
        if (sNode == null) {
            System.out.println("待添加Node为空，无法添加");
            return;
        }
        SnakeNode temp = head;
        //2. 遍历寻找链表末尾
        while (true) {
            //2.1 找到链表末尾
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //3. 添加新节点
        temp.next = sNode;
        sNode.pre = temp;
    }

    //删除某个节点
    public void delete(int no) {
        if (head.next == null) {
            return;
        }
        boolean flag = false;

        SnakeNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            System.out.println("已完成编号:" + no + "的节点删除");
        } else {
            System.out.println("链表中未发现该节点，无法删除");
        }
    }

    //修改某个节点
    public void update(SnakeNode sNode) {
        if (head.next == null) {
            return;
        }
        boolean flag = false;

        SnakeNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == sNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = sNode.name;
            System.out.println("已完成编号:" + sNode.no + "的节点的更新");
        } else {
            System.out.println("链表中未发现该节点，无法更新");
        }
    }

    //ex:按顺序添加node
    public void addSort(SnakeNode sNode) {
        if (sNode == null) {
            return;
        }
        SnakeNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no >= sNode.no) {
                flag  = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.pre = sNode;
            sNode.next = temp.next;
            temp.next = sNode;
            sNode.pre = temp;
        } else {
            temp.next = sNode;
            sNode.pre = temp;
        }
    }
}
