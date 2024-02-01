import java.util.Collection;

public class SearchTree<E extends Comparable<E>>  {
	public E data; //data stored in node
	public SearchTree<E> left; //left subtree
	public SearchTree<E> right; //right subtree
	public SearchTree<E> overallRoot;
	public int size;
	public Collection<Integer> list;
		//constructs node with given data
	/*public SearchTree() {
		this(null);
	}

	public SearchTree(E data) {
		this(data,null, null);
	}
	public SearchTree(E data, SearchTree<E> left, SearchTree<E> right) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	private SearchTree<E> add(SearchTree<E> root, E value) {
			if(root == null) {
				root = new SearchTree<E>(value);
			}else if( ((Comparable<E>) value).compareTo(root.data) <= 0) {
				root.left = add(root.left, value);
			}else if(((Comparable<E>) value).compareTo(root.data) <= 0) {
				root.left = add(root.right, value);
			}
			return root;
	}
	
	private boolean contains(SearchTree<E> root, E value) {
		if(root == null) {
			return false;
		}else {
			int compare = ((Comparable<E>) value).compareTo(root.data);
			if(compare == 0) {
				return true;
			}else if(compare<0) {
				return contains(root.left,value);
			}else {
				return contains(root.right,value);
			}
			
		}
		
	}*/
	//Default Constructor, sets overallRoot to null.
		public SearchTree() {
			this.overallRoot  = null; //sets root to null
		}
		
		/*Constructor that sets overallRoot to a
		new node with value as the parameter for the method. Also, ensure that the
		left and right field are initialized as null.*/
		public SearchTree( E value ) {
			this.overallRoot = new SearchTree(value); //creates node and size +1
			size++;
		}
		
		/*Constructor that sets the
		overallRoot and adds the listed Integers to the tree in the specified order.
		Be sure to import Collection from util. How can you see the value in ANY list?*/
		public SearchTree( Collection<Integer> list) {
			for(Integer num : list) {
				add(num); //calls add method and adds one each time
				size++;
			}
		}
		
		//Returns the current size of the tree.
		public int getSize() {
			return size;//returns size
		}
		
		//Empties the tree.
		public void clear() {
			overallRoot = null; //sets tree no null  
			size = 0; //size to 0
		}
		
		//Returns the smallest value in the tree. Throw an
		//IllegalStateException if the tree is empty.
		public int smallest() {
			SearchTree curr = overallRoot; //temp
			if(isEmpty()) {
				throw new IllegalStateException();
			}else {
				while(curr.left != null) { //keeps going to the left node till it cant
					curr = curr.left; //goes left
				}
			}
			return curr.data; //once there it returns the data
		}
		
		//Returns the largest value in the tree. Throw an
		//IllegalStateException if the tree is empty.
		public int largest() {
			SearchTree curr = overallRoot; //temp
			if(isEmpty()) {
				throw new IllegalStateException();
			}else {
				while(curr.right != null) { //goes to the farthest right node until it cannot
					curr = curr.right;
				}
			}
			return curr.data; //once there returns the data from that code
		}
		
		//Returns the number of leave nodes in the tree. Return -1
		//if the tree is empty.
		public int countLeaves() {
			if(isEmpty()) { //if empty returns -1
				return -1;
			}
			return countLeavesRecursive(overallRoot);
		}
		
		private int countLeavesRecursive(SearchTree<E> node) {
			if(node == null) { //base case
				return 0;
			}
			if(node.left == null && node.right == null) { //counts every leaf
				return 1;
			}
			
			int leftLeaves = countLeavesRecursive(node.left); //calls recursion
			int rightLeaves = countLeavesRecursive(node.right); //call recursion
			return 0;
		}

		//Returns true if the list is empty and should return false if
		//the list is not empty.
		public boolean isEmpty() {
			if(size == 0) { //if empty returns true
				return true;
			}
			return false; //if not, false
		}
		
		/*Adds the given value to the appropriate place in
		the tree to maintain ordering; returns true if added successfully or returns
		false if the item is already in the tree. No duplicates are allowed.*/
		public boolean add( E value ) {
			if(overallRoot == null) { //if tree is null
				overallRoot = new SearchTree(value); //creates overallRoot
				size++; //size + 1
				return true; //returns true
			}
			SearchTree curr = overallRoot; //current temp
			SearchTree parent = null; //previous node temp
			while(curr != null) { //loop to traverse
				parent = curr; //sets previous to current
				if((Comparable<E>)value.compareTo(parent.data) > 0) { //checks see where value goes
					curr = curr.right;
				}else if(value < parent.data) { //checks see where value goes
					curr = curr.left;
				}else { //if equal returns false
					return false;
				}
			 }
			
			if(value < parent.data) { //checks to see what side
				parent.left = new SearchTree(value);
			}
			if(value > parent.data) { //checks to see what side
				parent.right = new SearchTree(value);
			}
			size++; //size + 1
			return true;
			
			
		}
		
		//Returns true if the value is in the list,
		//otherwise return false.
		public boolean contains( int value ) {
			if(add(value) == false) { //uses add value to check
				return true;
			}
			return false;
		}
		
		//Returns the
		//node/memory address with the minimum value for the given tree. Return
		//null if the root is null.
		private static SearchTree minNode( SearchTree root ) {
			SearchTree curr = root; //uses starting root and then checks smallest node from that given tree
			while(curr != null) {
				curr = curr.left;
			}
			return curr;	
			
		}
		
		/*Removes the node with the given number from
		the tree, if present, in a way that maintains BST ordering. Return true if the
		node was successfully removed and return false if the number was not in the
		list. Tips are mentioned in the MISC section of this document.*/
		
		public boolean remove( int num ) {
			if(isEmpty()) { //checks size 
				System.out.println("IS EMPTY");
				return false;
			}
			if(num == overallRoot.data) { //if overallRoot is to be removed
				overallRoot = null; //sets to null
				size--; //changes size
				return true;
			}
			SearchTree curr = overallRoot; //current temp
			SearchTree parent = null; //previous node to current
			
			
			while(curr != null && curr.data != num) { //traverse
				parent = curr; //sets prevoius and current to each other
				if(num < parent.data) { //checks left node
					curr = curr.left; //moves left
				}else if(num > parent.data) {//checks right node
					curr = curr.right; //moves right
				}
			}
			if(curr == null || parent == null) { //current is null
				size--; //changes size
				return true;
			}
			//if node is a leaf (no children)
			if(curr.left == null && curr.right == null) 
			{
				if(num < parent.data) { //checks left node
					parent.left = null; //makes left null
				}
				if(num > parent.data) { // checks right node
					parent.right = null; //moves right node
				}
			}
			//if node has only left child or if node has only right child
			if(curr.left == null || curr.right == null) {
				IntTreeNode child = (curr.left != null) ? curr.left : curr.right; //creates a temp of child
				if(curr == parent.left) {//checks left
					parent.left = child; //points to left
				}else { //if not
					parent.right = child; //points to right
				}
			}
			//if node has both children
			if(curr.left != null && curr.right != null) {
				//IntTreeNode leftChild = curr.left;IntTreeNode rightChild = curr.right;
				//if(parent.left != null) {
				//	parent.left = rightChild;
				//	rightChild.left = leftChild;
				//}
				//if(parent.right != null) {
				//	parent.right = leftChild;
				//	leftChild.right = rightChild;
				//}
				SearchTree minNode = minNode(curr); //creates a temp of minNode of tree
				if(parent.left == curr) { //checks left
					parent.left = minNode; //points to minNode
				}else { //if not 
					parent.right = minNode; //right size points to minNode
				}
			}
			size--; //changes size
			return true;
			
		}
		
		//Returns a String of the tree in-order with each number
		//separated by a space.
		public String toString() {
			return printInOrder(overallRoot); //calls inOrder method
		}
		private static String printInOrder(SearchTree root){
			/* Prints the given tree using the in-order pattern
			 */
			/*StringBuilder result = new StringBuilder();
			IntTreeNode curr = root;
			
			if(curr.left != null && curr.right != null) {
				return result;
			}
			else if (curr.left != null){
				return printInOrder(curr.left);
			}
			result.append(curr.data + " ");
			System.out.println(curr.data);
			else if (curr.right != null){
				return printInOrder(curr.right);
			}
		}*/
			SearchTree current, parent; //creates current and previous current node
			StringBuilder result = new StringBuilder(); //creates the result
			 
	        if (root == null) //if null return null
	            return null;
	 
	        current = root; // root sets to current
	        while (current != null) //loop to traverse
	        {
	            if (current.left == null)  //if left side null
	            {
	                result.append(current.data + " "); //add num to result
	                current = current.right; //move right
	            }
	            else {
	                //Find the inorder predecessor of current
	                parent = current.left; //moves parent to left node
	                while (parent.right != null && parent.right != current) //loop to check
	                    parent = parent.right; //moves right
	 
	                //Make current as right child of its inorder predecessor 
	                if (parent.right == null) { //checks right node
	                    parent.right = current; //sets right node to current
	                    current = current.left; //moves current
	                }
	 
	                //Revert the changes made in the 'if' part to restore the original 
	                //tree i.e., fix  the right child of parentdecessor
	                else
	                {
	                    parent.right = null; //once at the end, right node is null
	                    result.append(current.data + " "); //adds data to result
	                    current = current.right; //moves right
	                } /* End of if condition parent->right == NULL
	                   */
	 
	            } /* End of if condition current->left == NULL*/
	 
	        }
	        return result.toString();/* End of while */
		}

}
