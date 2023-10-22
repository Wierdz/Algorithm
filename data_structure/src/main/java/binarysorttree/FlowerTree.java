package binarysorttree;

/**
 * @author Wierdz
 * @version 1.0
 */
public class FlowerTree {
    public FlowerNode root;

    public FlowerNode searchFlower(int target) {
        if (root == null) {
            return null;
        }
        return root.searchFlower(target);
    }

    public FlowerNode searchParent(int target) {
        if (root == null) {
            return null;
        }
        return root.searchParent(target);
    }

    public int delRightMin(FlowerNode node) {
        if (node == null || node.right == null) {
            System.out.println("没有右子树");
        }
        FlowerNode subFlower = node.right;
        while (subFlower.left != null) {
            subFlower = subFlower.left;
        }
        delFlower(subFlower.no);
        return subFlower.no;
    }

    public void delFlower(int target) {
        if (root == null) {
            System.out.println("二叉排序树为空");
            return;
        }
        FlowerNode resFlower = searchFlower(target);
        if (resFlower == null) {
            System.out.println("二叉树上没有找到目标结点");
            return;
        }
        FlowerNode resParent = searchParent(target);
        //1.按照target的情况分类讨论
        //1.1 删除结点为叶子结点
        if (resFlower.left == null && resFlower.right == null) {
            if (resParent == null) {
                resFlower = null;
            } else {
                if (resParent.left.no == target) {
                    resParent.left = null;
                } else {
                    resParent.right = null;
                }
            }
        } else if (resFlower.left != null && resFlower.right != null) {
            //1.2 删除结点有两个子结点
            //删除右树最小结点(左树最大结点)后，将其值赋予resFlower
            int rightMinValue = delRightMin(resFlower);
            resFlower.no = rightMinValue;

        } else {
            //1.3 删除结点只有一个子结点
            if (resParent == null) {
                if (resFlower.left == null) {
                    resFlower = resFlower.right;
                } else {
                    resFlower = resFlower.left;
                }
            } else {
                if (resFlower.left == null) {
                    if (resParent.left.no == target) {
                        resParent.left = resFlower.right;
                    } else {
                        resParent.right = resFlower.right;
                    }
                } else {
                    if (resParent.left.no == target) {
                        resParent.left = resFlower.left;
                    } else {
                        resParent.right = resFlower.left;
                    }
                }
            }
        }
    }
}
