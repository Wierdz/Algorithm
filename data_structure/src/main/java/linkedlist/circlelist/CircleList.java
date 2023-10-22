package linkedlist.circlelist;

/**
 * @author Wierdz
 * @version 1.0
 */
public class CircleList {
    public BoyNode first;

    //构造长度为len的环形链表
    public void createCircleList(int len) {
        //参数校验
        if (len < 1) {
            System.out.println("输入参数至少为1");
            return;
        }

        BoyNode temp = null;
        for (int i = 1; i <= len; i++) {
            BoyNode bNode = new BoyNode(i);
            if (i == 1) {//首个节点的next指向自己
                first = bNode;
                first.setNext(bNode);
                temp = first;
            } else {//temp节点的next指向新节点，新节点的next指向first
                temp.setNext(bNode);
                bNode.setNext(first);
                temp = bNode;//将temp移至环形链表first的前一个节点
            }
        }
    }

    /**
     * 遍历环形链表的方法，注意点如下：
     * 1. 遍历的终点是temp.next == first
     */
    public void show() {
        //1. 空值校验
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        BoyNode temp = first;

        while (true) {
            System.out.println(temp);

            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }
    public int getLength() {
        if (first == null) {
            System.out.println("链表为空");
            return 0;
        }
        int len = 0;
        BoyNode curBoy = first;
        while (true) {
            len++;
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        return len;
    }

    /**
     * @param startNo 开始的编号
     * @param slide   出列间隔步长
     */
    public void joseph(int startNo, int slide) {
        //1. 空值校验
        if (startNo > getLength() || startNo < 1 || first == null) {
            System.out.println("输入参数有误");
            return;
        }
        //2. 定义辅助指针helper并移至末端
        BoyNode helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //3. helper与first均移动startNo-1次
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //4. 出链表直至helper指向first
        int count = 0;

        while (true) {
            count++;
            if (helper == first) {
                break;
            }
            for (int j = 1; j < slide; j++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.printf("第%d个出列的元素编号为%d\n",count,first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("第%d个出列的元素编号为%d\n",count,first.getNo());
    }
}
