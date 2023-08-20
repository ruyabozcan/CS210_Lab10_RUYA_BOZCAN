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

public class PrintTree
{
    private Node root;

    public PrintTree()
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

    public int treeHeight()
    {
        return calculateHeight(root);
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

    public void printTree()
    {
        printTree(root, 0);
    }

    private void printTree(Node node, int level)
    {
        if (node == null)
        {
            return;
        }

        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++)
        {
            System.out.print("    ");
        }
        System.out.println(node.data);

        printTree(node.left, level + 1);
    }

    public static void main(String[] args)
    {
        PrintTree tree = new PrintTree();

        // Insert nodes into the binary search tree
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        // Print the tree structure with the root at the topmost position
        System.out.println("Tree structure with root at top:");
        tree.printTree();

        // Calculate and print the height of the tree
        int height = tree.treeHeight();
        System.out.println("Height of the tree: " + height);
    }
}
