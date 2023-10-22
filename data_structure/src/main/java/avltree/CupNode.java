package avltree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class CupNode {
    public int value;

    public CupNode left;
    public CupNode right;

    public CupNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CupNode{" +
                "value=" + value +
                '}';
    }

    /**
     * 左旋
     */
    public void leftRotate() {
        //创建新结点
        CupNode newNode = new CupNode(value);
        //新结点左子树为当前左子树
        newNode.left = this.left;
        //新结点右子树为当前右子树的左子树
        newNode.right = this.right.left;
        //当前结点值换位右结点值
        this.value = this.right.value;
        //当前结点的右结点为当前右结点的右结点
        this.right = this.right.right;
        //当前结点的左结点为新结点
        this.left = newNode;
    }

    /**
     * 右旋
     */
    public void rightRotate() {
        CupNode newNode = new CupNode(value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    public int leftHeight() {
        if (this.left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (this.right == null) {
            return 0;
        }
        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public void add(CupNode cNode) {
        if (cNode == null) {
            System.out.println("参数不能为空");
            return;
        }
        if (cNode.value <= this.value) {
            if (this.left == null) {
                this.left = cNode;
            } else {
                this.left.add(cNode);
            }
        } else {
            if (this.right == null) {
                this.right = cNode;
            } else {
                this.right.add(cNode);
            }
        }
        //左子树比右子树高2层时，进行右旋
        if (leftHeight() - rightHeight() > 1) {
            //左子树的右子树的高度>左子树的左子树高度，先左子树左旋，整体再右旋
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                //若不满足，直接右旋
                rightRotate();
            }
        }
        if (leftHeight() - rightHeight() < -1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            right.infixOrder();
        }
    }
}
