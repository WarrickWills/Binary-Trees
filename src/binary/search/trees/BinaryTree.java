package binary.search.trees;

/**
 * @author Jack Finlay - 1399273
 * @author Warrick Wills - 13831575
 */
public class BinaryTree<E> {

    protected BinaryTree<E> parent, left, right;
    protected String name;
    protected int mark;

    public BinaryTree() {
        left = null;
        right = null;
        name = null;
        mark = 0;

    }

    public BinaryTree(String name, int mark) {
        this.left = null;
        this.right = null;

        this.name = name;
        this.mark = mark;

    }

    public BinaryTree<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<E> parent) {
        this.parent = parent;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
        left.setParent(this);
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
        right.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isEmpty() {
        return (name == null && mark == 0);
    }
}
