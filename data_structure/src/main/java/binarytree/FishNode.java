package binarytree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class FishNode {
    private int no;
    private String name;
    private FishNode left;
    private FishNode right;

    public FishNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FishNode{" +
                "no=" + no +
                ", name=" + name +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FishNode getLeft() {
        return left;
    }

    public void setLeft(FishNode left) {
        this.left = left;
    }

    public FishNode getRight() {
        return right;
    }

    public void setRight(FishNode right) {
        this.right = right;
    }

    //1. 前序遍历
    //说明，因为需要用到递归，所以该方法只能写在FishNode类中，无法写在FishTree中
    public void preList() {
        System.out.println(this);
        if (left != null) {
            left.preList();
        }
        if (right != null) {
            right.preList();
        }
    }
    //2. 中序遍历
    public void midList() {
        if (left != null) {
            left.midList();
        }
        System.out.println(this);
        if (right != null) {
            right.midList();
        }
    }
    //3. 后续遍历
    public void posList() {
        if (left != null) {
            left.posList();
        }
        if (right != null) {
            right.posList();
        }
        System.out.println(this);
    }

    //1. 前序遍历查找
    public FishNode preSearch(int no) {
        FishNode resFish = null;
        if (this.no == no) {
            resFish = this;
        }
        if (left != null) {
            resFish = left.preSearch(no);
        }
        if (resFish != null) {
            return resFish;
        }
        if (right != null) {
            resFish = right.preSearch(no);
        }
        return resFish;
    }

    //2.删除节点 若为叶子结点 则删除本身，否则删除子树
    public void del(int no) {
        boolean flag = false;
        if (this.no == no) {
            flag = true;

        }
    }

}
