public class BalanceFactor
{
    private Node root;
    public BalanceFactor()
    {
        root = null;
    }

    public void insert(int data)
    {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data)
    {
        if (current == null)
        {
            return new Node(data);
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

    public void printTreeWithBalanceFactor()
    {
        printTreeWithBalanceFactor(root, 0);
    }

    private void printTreeWithBalanceFactor(Node node, int level)
    {
        if (node == null)
        {
            return;
        }

        printTreeWithBalanceFactor(node.right, level + 1);

        for (int i = 0; i < level; i++)
        {
            System.out.print("    ");
        }
        System.out.print(node.data + " ");

        int balanceFactor = calculateBalanceFactor(node);
        System.out.println("(Balance Factor: " + balanceFactor + ")");

        printTreeWithBalanceFactor(node.left, level + 1);
    }

    private int calculateBalanceFactor(Node node)
    {
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return leftHeight - rightHeight;
    }

    private int calculateHeight(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args)
    {
        BalanceFactor tree = new BalanceFactor();

        // Insert nodes into the binary search tree
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        // Print the tree structure with balance factors
        System.out.println("Tree structure with balance factors:");
        tree.printTreeWithBalanceFactor();
    }
}
