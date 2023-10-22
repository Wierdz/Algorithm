package binarysorttree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class FlowerNode {
    public int no;
    public String name;

    public FlowerNode left;
    public FlowerNode right;

    public FlowerNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlowerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void addFlower(FlowerNode node) {
        //1.空值校验
        if (node == null) {
            System.out.println("参数为空");
            return;
        }
        if (node.no < this.no) {
            if (left == null) {
                left = node;
            } else {
                left.addFlower(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.addFlower(node);
            }
        }
    }

    public void infixList() {
        if (left != null) {
            left.infixList();
        }
        System.out.println(this);
        if (right != null) {
            right.infixList();
        }
    }

    public FlowerNode searchFlower(int target) {
        if (no == target) {
            return this;
        }
        if (no < target && left != null) {
            return left.searchFlower(target);
        }
        if (no > target && right != null) {
            return right.searchFlower(target);
        }
        return null;
    }

    public FlowerNode searchParent(int target) {
        if ((left != null && left.no == target) || (right != null && right.no == target)) {
            return this;
        }
        if (left != null && target < left.no) {
            return left.searchParent(target);
        }
        if (right != null && target >= right.no) {
            return right.searchParent(target);
        }
        return null;
    }
}
