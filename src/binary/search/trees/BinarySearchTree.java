package binary.search.trees;


import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Jack Finlay - 1399273
 * @author Warrick Wills - 13831575
 */
public class BinarySearchTree<E extends Comparable<E>> {

    BinaryTree<E> root;
    int size;

    public BinarySearchTree(){
        root = new BinaryTree<E>();
        size = 0;
    }

    public void add(E value, int mark) {
        BinaryTree<E> addLoc = locate(root, value);
        if (value.compareTo((E) addLoc.getName()) == 0) {
            value = (E) (value + "(1)");
        }

        BinaryTree<E> newNode = new BinaryTree<E>((String) value, mark);

        if (root.isEmpty()) {
            root = newNode;
        } else {
            if (value.compareTo((E) addLoc.getName()) > 0) {
                addLoc.setRight(newNode);
            } else {
                addLoc.setLeft(newNode);
            }
        }
    }

    public E search(E k) {
        if (!contains(k)) {
            return null;
        }

        BinaryTree<E> t = locate(root, k);
        return (E) ((Integer) t.getMark());
    }

    public boolean change(E k, int v) {
        if (!contains(k)) {
            return false;
        }

        BinaryTree<E> toChange = locate(root, k);
        toChange.setMark(v);
        return true;
    }

    public boolean remove(E v) {
        //Remove the first occurrence of v
        if (!contains(v)) {
            return false;
        }

        BinaryTree<E> locNode = locate(root, v);
        // Find the first occurrence of v
        if (locNode.equals(root)) {
            root = removeNode(locNode);
        } else if (locNode.equals(locNode.getParent().getLeft())) {
            locNode.getParent().setLeft(removeNode(locNode));
        } else {
            locNode.getParent().setRight(removeNode(locNode));
        }

        return true;
    }

    public BinaryTree<E> removeNode(BinaryTree<E> k) { // Return the resulting tree after k is removed
        if (k.getLeft().isEmpty() && k.getRight().isEmpty())
            return new BinaryTree<>();
        else if (k.getLeft().isEmpty())
            return k.getRight();
        else if (k.getRight().isEmpty())
            return k.getLeft();
        else {
            BinaryTree<E> pre = predecessor(k);
            pre.getParent().setRight(pre.getLeft());
            BinaryTree<E> le = k.getLeft();
            BinaryTree<E> ri = k.getRight();
            k.setLeft(new BinaryTree<E>());
            k.setRight(new BinaryTree<E>());
            pre.setLeft(le);
            pre.setRight(ri);
            return pre;
        }
    }

    public BinaryTree<E> predecessor(BinaryTree<E> k) {
        BinaryTree<E> left = k.getLeft();

        BinaryTree<E> predecessor = maximumValue(left);

        return predecessor;
    }

    public BinaryTree<E> maximumValue(BinaryTree<E> k) {
        if (k == null) {
            return null;
        }

        if (k.getRight() != null) {
            return maximumValue(k.getRight());
        }

        return k;
    }

    public boolean contains(E value) {
        if (root.isEmpty()) {
            return false;
        }
        BinaryTree<E> loc = locate(root, value);
        return value.equals(loc.getName());
    }

    public E get(E value) {
        if (root.isEmpty()) {
            return null;
        }

        BinaryTree<E> loc = locate(root, value);
        if (!value.equals(loc.getName())) {
            return null;
        } else {
            return (E) loc.getName();
        }
    }

    protected BinaryTree<E> locate(BinaryTree<E> root, E val) {
        E rootVal = (E) root.getName();
        BinaryTree<E> child;

        if (rootVal.equals(val)) {
            return root;
        }
        if (val.compareTo(rootVal) < 0) {
            child = root.getLeft();
        } else {
            child = root.getRight();
        }
        if (child.isEmpty()) return root;
        else return locate(child, val);
    }
    
    public void drawTree(Graphics g) {
        
    }

}
