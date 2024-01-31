import java.util.Collection;

public class BinarySearchIntTree {
	//Instance Variables
	public IntTreeNode overallRoot;
	public int size;
	public Collection<Integer> list;
	
	//Default Constructor, sets overallRoot to null.
	public BinarySearchIntTree() {
		this.overallRoot  = null;
	}
	
	/*Constructor that sets overallRoot to a
	new node with value as the parameter for the method. Also, ensure that the
	left and right field are initialized as null.*/
	public BinarySearchIntTree( int value ) {
		this.overallRoot = new IntTreeNode(value);
		size++;
	}
	
	/*Constructor that sets the
	overallRoot and adds the listed Integers to the tree in the specified order.
	Be sure to import Collection from util. How can you see the value in ANY list?*/
	public BinarySearchIntTree( Collection<Integer> list) {
		for(Integer num : list) {
			add(num);
			size++;
		}
	}
	
	//Returns the current size of the tree.
	public int getSize() {
		return size;
	}
	
	//Empties the tree.
	public void clear() {
		overallRoot = null;
		size = 0;
	}
	
	//Returns the smallest value in the tree. Throw an
	//IllegalStateException if the tree is empty.
	public int smallest() {
		IntTreeNode curr = overallRoot;
		if(isEmpty()) {
			throw new IllegalStateException();
		}else {
			while(curr.left != null) {
				curr = curr.left;
			}
		}
		return curr.data;
	}
	
	//Returns the largest value in the tree. Throw an
	//IllegalStateException if the tree is empty.
	public int largest() {
		IntTreeNode curr = overallRoot;
		if(isEmpty()) {
			throw new IllegalStateException();
		}else {
			while(curr.right != null) {
				curr = curr.right;
			}
		}
		return curr.data;
	}
	
	//Returns the number of leave nodes in the tree. Return -1
	//if the tree is empty.
	public int countLeaves() {
		if(isEmpty()) {
			return -1;
		}
		int count = 0;
		 IntTreeNode curr = overallRoot;
		while(curr != null) {
			if(curr.left != null) {
				count++;
				curr = curr.left;
			}
			if(curr.right != null) {
				count++;
				curr = curr.right;
			}
		 }
		 return count;
	}
	
	//Returns true if the list is empty and should return false if
	//the list is not empty.
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	/*Adds the given value to the appropriate place in
	the tree to maintain ordering; returns true if added successfully or returns
	false if the item is already in the tree. No duplicates are allowed.*/
	public boolean add( int value ) {
		if(overallRoot == null) {
			overallRoot = new IntTreeNode(value);
			size++;
			return true;
		}
		IntTreeNode curr = overallRoot;
		IntTreeNode parent = null;
		while(curr != null) {
			parent = curr;
			if(value > parent.data) {
				curr = curr.right;
			}else if(value < parent.data) {
				curr = curr.left;
			}else {
				return false;
			}
		 }
		
		if(value < parent.data) {
			parent.left = new IntTreeNode(value);
		}
		if(value > parent.data) {
			parent.right = new IntTreeNode(value);
		}
		size++;
		return true;
		
		
	}
	
	//Returns true if the value is in the list,
	//otherwise return false.
	public boolean contains( int value ) {
		if(add(value) == false) {
			return true;
		}
		return false;
	}
	
	//Returns the
	//node/memory address with the minimum value for the given tree. Return
	//null if the root is null.
	private static IntTreeNode minNode( IntTreeNode root ) {
		IntTreeNode curr = root;
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
		if(isEmpty()) {
			return false;
		}
		if(size == 1) {
			if(num == overallRoot.data) {
				overallRoot = null;
			}
		}
		IntTreeNode curr = overallRoot;
		IntTreeNode parent = null;
		while(curr != null && curr.data != num) {
			parent = curr;
			if(num < parent.data) {
				curr = curr.left;
			}else if(num > parent.data) {
				curr = curr.right;
			}
		}
		//if node is a leaf (no children)
		if(curr.left == null && curr.right == null)
		{
			if(num < parent.data) {
				parent.left = null;
			}
			if(num > parent.data) {
				parent.right = null;
			}
		}
		//if node has only left child or if node has only right child
		if(curr.left == null || curr.right == null) {
			IntTreeNode child = (curr.left != null) ? curr.left : curr.right;
			if(parent.data < child.data) {
				parent.right = child;
			}
			if(parent.data > child.data) {
				parent.left = child;
			}
		}
		//if node has both children
		if(curr.left != null && curr.right != null) {
			IntTreeNode leftChild = curr.left;IntTreeNode rightChild = curr.right;
			//if(parent.data < leftChild.data) {
			//	parent.right = child;
			//}
			//if(parent.data > leftChild.data) {
			//	parent.left = child;
			//}
			if(curr.left != null) {
				parent.left = rightChild;
				rightChild.left = leftChild;
			}
			if(curr.right != null) {
				parent.right = leftChild;
				leftChild.right = rightChild;
			}
		}
		return true;
		
	}
	
	//Returns a String of the tree in-order with each number
	//separated by a space.
	public String toString() {
		
		return printInOrder(overallRoot);
		
	}
	private static String printInOrder(IntTreeNode root){
		/* Prints the given tree using the in-order pattern
		 */
		String result = "";
		IntTreeNode curr = root;
		if(curr == null) {
			return result;
		}
		if (curr.left != null){
			return printInOrder(curr.left);
		}
		result = result + " " + root.data + "";
		if (curr.right != null){
			return printInOrder(curr.right);
		}
		return result;
	}
}
