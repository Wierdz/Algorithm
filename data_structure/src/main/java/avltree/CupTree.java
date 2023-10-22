package avltree;

import javax.swing.*;
import java.util.zip.Inflater;

/**
 * @author Wierdz
 * @version 1.0
 */
public class CupTree {
    public CupNode root;

    public void addCup(CupNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    public void infixOrder() {
        if (root == null) {
            System.out.println("树为空");
            return;
        } else {
            root.infixOrder();
        }
    }
}
