package binary.search.trees;

import java.util.Iterator;

/**
 * @author Jack Finlay - 1399273
 * @author Warrick Wills - 13831575
 */
public class SplayTree<E extends Comparable<E>> extends BinarySearchTree<E> {
    public SplayTree() {

    }

    public void add(E val, int mark) {
        super.add(val, mark);
        splay(root);
    }

    public boolean contains(E val) {
        boolean found = true;
        if (root.isEmpty()) found = false;
        BinaryTree<E> loc = locate(root, val);
        if (val.equals(loc.getMark())) {
            splay(loc);
            root = loc;
        } else found = false;
        return found;
    }

    public E get(E val) {
        E get = super.get(val);

        splay(root);

        return get;
    }

    public boolean remove(E val) {
        splay(root);

        boolean removed = val == (E) (Integer) locate(root, val).getMark();
        super.remove(val);

        return removed;
    }

    protected void splay(BinaryTree<E> x) {
        while (x.getParent() != null) {
            BinaryTree parent = x.getParent();
            BinaryTree grandParent = parent.getParent();
            if (grandParent == null) {
                if (x == parent.getLeft()) {
                    rotateLeft(x);
                } else {
                    rotateRight(x);
                }
            } else {
                if (x == parent.getLeft()) {
                    if (parent == grandParent.getLeft()) { // Both x and parent are left children
                        rotateLeft(parent);
                        rotateLeft(x);
                    }
                } else if (x == parent.getRight()) {
                    if (parent == grandParent.getRight()) { // Both x and parent are right children
                        rotateRight(parent);
                        rotateRight(x);
                    }
                } else { // Child is left or right and parent is the other child
                    rotateLeft(x);
                    rotateLeft(x);
                }
            }

        }
    }

    protected void rotateRight(BinaryTree<E> x) {

        BinaryTree<E> parent = x.getParent();
        BinaryTree<E> newRoot = x.getLeft();
        BinaryTree<E> oldRight = newRoot.getRight();
        boolean wasChild = parent != null;
        boolean wasLeftChild = isLeftChild(x);
        newRoot.setRight(x);
        x.setLeft(oldRight);
        if (wasChild) {
            if (wasLeftChild) parent.setLeft(newRoot);
            else parent.setRight(newRoot);
        }
    }

    protected void rotateLeft(BinaryTree<E> x) {

        BinaryTree<E> parent = x.getParent();
        BinaryTree<E> newRoot = x.getRight();
        BinaryTree<E> oldLeft = newRoot.getLeft();
        boolean wasChild = parent != null;
        boolean wasRightChild = isRightChild(x);
        newRoot.setLeft(x);
        x.setRight(oldLeft);
        if (wasChild) {
            if (wasRightChild) parent.setRight(newRoot);
            else parent.setLeft(newRoot);
        }
    }

    public boolean isRightChild(BinaryTree<E> x) {
        return x.parent.getRight() == x;
    }

    public boolean isLeftChild(BinaryTree<E> x) {
        return x.parent.getLeft() == x;
    }
}
