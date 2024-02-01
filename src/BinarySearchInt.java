
public class BinarySearchInt {
	public int data;            //data stored at this node
    public IntTreeNode left;    //reference to left subtree
    public IntTreeNode right;   //reference to right subtree

    // Constructs a leaf node with the given data
    public BinarySearchInt()
    {
        this(0, null, null);
    }

    public BinarySearchInt(int data)
    {
        this(data, null, null);
    }

    // Constructs a branch node with the given data and links
    public BinarySearchInt(int data, IntTreeNode left, IntTreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
