//Name:
//Class Period:


/*************************************
 * Mini-Lab: Tree Traversal
 *
 * Given a tree, create recursive print 
 * methods for each traversl pattern.
 *
 *	pre-, in-, & post- order
 *
 *************************************/

public class TreesTraversalMiniLab
{
		
	public static void main (String[] args) 
	{
		//Creating the Tree
		IntTreeNode overallRoot = new IntTreeNode(17);
		overallRoot.left = new IntTreeNode(41, new IntTreeNode(29), new IntTreeNode(6));
		overallRoot.right = new IntTreeNode(9, new IntTreeNode(81), new IntTreeNode(40));
		
		//CALL the 3 print methods using the overallRoot
		//printPreOrder(overallRoot);
		//printInOrder(overallRoot);
		printPostOrder(overallRoot);
		
	}
	
	public static void printPreOrder(IntTreeNode root){
		/* Prints the given tree using the pre-order pattern
		 */
		IntTreeNode curr = root;
		System.out.print(root.data + " ");
		 if (curr.left != null){
			 	printPreOrder(curr.left);
		    }
		    		    if (curr.right != null){
		    	printPreOrder(curr.right);
		    }
	}
	
	public static void printInOrder(IntTreeNode root){
		/* Prints the given tree using the in-order pattern
		 */
		 IntTreeNode curr = root;
		 if (curr.left != null){
			 	printInOrder(curr.left);
		    }
		    System.out.print(root.data + " ");
		    if (curr.right != null){
		    	printInOrder(curr.right);
		    }
	}
	
	public static void printPostOrder(IntTreeNode root){
		/* Prints the given tree using the pre-order pattern
		 */
		IntTreeNode curr = root;
		
		 if (curr.left != null){
			 	printPostOrder(curr.left);
		    }
		 if (curr.right != null){
		    	printPostOrder(curr.right);
		    }
		 System.out.print(root.data + " ");
	}

}

class IntTreeNode
{
	public int data;            // data stored at this node
    public IntTreeNode left;    // reference to left subtree
    public IntTreeNode right;   // reference to right subtree
        
    // Constructs a leaf node with the given data.
    public IntTreeNode(int data) {
        this(data, null, null);
    }
                
    // Constructs a branch node with the given data and links.
    public IntTreeNode(int data, IntTreeNode left,
                                 IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}