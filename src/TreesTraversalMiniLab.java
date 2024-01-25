
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
		IntTreeNode2 overallRoot = new IntTreeNode2(17);
		overallRoot.left = new IntTreeNode2(41, new IntTreeNode2(29), new IntTreeNode2(6));
		overallRoot.right = new IntTreeNode2(9, new IntTreeNode2(81), new IntTreeNode2(40));
		
		//CALL the 3 print methods using the overallRoot
		//printPreOrder(overallRoot);
		//printInOrder(overallRoot);
		printPostOrder(overallRoot);
		
	}
	
	public static void printPreOrder(IntTreeNode2 root){
		/* Prints the given tree using the pre-order pattern
		 */
		IntTreeNode2 curr = root;
		System.out.print(root.data + " ");
		 if (curr.left != null){
			 	printPreOrder(curr.left);
		    }
		    		    if (curr.right != null){
		    	printPreOrder(curr.right);
		    }
	}
	
	public static void printInOrder(IntTreeNode2 root){
		/* Prints the given tree using the in-order pattern
		 */
		 IntTreeNode2 curr = root;
		 if (curr.left != null){
			 	printInOrder(curr.left);
		    }
		    System.out.print(root.data + " ");
		    if (curr.right != null){
		    	printInOrder(curr.right);
		    }
	}
	
	public static void printPostOrder(IntTreeNode2 root){
		/* Prints the given tree using the pre-order pattern
		 */
		IntTreeNode2 curr = root;
		
		 if (curr.left != null){
			 	printPostOrder(curr.left);
		    }
		 if (curr.right != null){
		    	printPostOrder(curr.right);
		    }
		 System.out.print(root.data + " ");
	}

}

class IntTreeNode2
{
	public int data;            // data stored at this node
    public IntTreeNode2 left;    // reference to left subtree
    public IntTreeNode2 right;   // reference to right subtree
        
    // Constructs a leaf node with the given data.
    public IntTreeNode2(int data) {
        this(data, null, null);
    }
                
    // Constructs a branch node with the given data and links.
    public IntTreeNode2(int data, IntTreeNode2 left,
                                 IntTreeNode2 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}