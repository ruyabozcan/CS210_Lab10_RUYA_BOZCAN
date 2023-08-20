class Nodee
{
    int data;
    Nodee left;
    Nodee right;

    public Nodee(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class AVLChecker
{
    private Nodee root;
    public AVLChecker()
    {
        root = null;
    }

    public void insert(int data)
    {
        root = insertRecursive(root, data);
    }

    private Nodee insertRecursive(Nodee current, int data)
    {
        if (current == null)
        {
            return new Nodee(data);
        }

        if (data < current.data)
        {
            current.left = insertRecursive(current.left, data);
        }

        else if (data > current.data)
        {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    public boolean isAVLTree()
    {
        return isAVLTreeRecursive(root);
    }

    private boolean isAVLTreeRecursive(Nodee nodee)
    {
        if (nodee == null)
        {
            return true;
        }

        int balanceFactor = calculateBalanceFactor(nodee);
        if (Math.abs(balanceFactor) > 1)
        {
            return false;
        }

        return isAVLTreeRecursive(nodee.left) && isAVLTreeRecursive(nodee.right);
    }

    private int calculateBalanceFactor(Nodee nodee)
    {
        int leftHeight = calculateHeight(nodee.left);
        int rightHeight = calculateHeight(nodee.right);

        return leftHeight - rightHeight;
    }

    private int calculateHeight(Nodee nodee)
    {
        if (nodee == null)
        {
            return 0;
        }

        int leftHeight = calculateHeight(nodee.left);
        int rightHeight = calculateHeight(nodee.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args)
    {
        AVLChecker tree = new AVLChecker();

        // Insert nodes into the binary search tree
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        // Check if the tree is an AVL tree
        boolean isAVL = tree.isAVLTree();
        System.out.println("Is AVL tree? " + isAVL);
    }
}
