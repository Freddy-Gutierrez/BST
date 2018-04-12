/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author mrfre
 */
public class BST {
	Node root;

	public BST(int value){
       root = new Node(value);                                              //creates the BST
	}

	public void insert(int value){                                      //function that calls the private version of insert, which always passes in the root
		insert(root, value);
	}
	
	private void insert(Node current, int value){
		if(current.left == null && value <= current.data){          //series of if-else-if to traverse through tree to find proper location of node
			Node temp = new Node(value);                        //keeps track of parents of each node
           	current.left = temp;
           	temp.parent = current;
		}
		else if(current.right == null && value > current.data){
			Node temp = new Node(value);
			current.right = temp;
			temp.parent = current;
		}
		else if(value <= current.data){
		   	insert(current.left, value);
		}
		else if(value >= current.data){
			insert(current.right,value);
		}		
	}
	
	public void delete(int data){
		Node parent;
		Node min;
	    Node val = search(data);                                        //scenario to attempt to deal with the user deleting the root from the BST
	    if(val.data == root.data){                                      //has the same scenarios as deleting other nodes, just that the root would be equal to null
	    	if(val.left == null && val.right == null){										
	    		root = null;
	    	}
	    	else if((val.left == null && val.right != null)){
	    		root = val.right;
	    		root.parent = null;
	    	}
	    	else if((val.left != null && val.right == null)){
	    		root = val.left;
	    		root.parent = null;
	    	}
	    	else if(val.left != null && val.right != null){
	    		if(val.left != null && root.left.data == val.data){
	    			if(val.right== null)
	    				root.left = null;
	    			else{
	    				min = minValue(val.right);
	    				root.left = min;
		    			min.parent = root;
	    			}
	    		}
	    		else{
	    			if(val.left == null)
	    				root.right = null;
	    			else{
	    				min = minValue(val.right);
	    				root.right = min;
	    				min.parent = root;
	    			}
	    		}
	    	}
	    } 
	     if(val.left == null && val.right == null){                     //similar to the checks for deleting the root, but this is specific to any node other than
	    	parent = val.parent;                                        //the root. remaps pointers, accordingly when deleting a node.
	    	if(parent.left != null && parent.left.data == val.data)
	    		parent.left = null;
	    	else if(parent.right != null && parent.right.data == val.data)
	    		parent.right = null; 		
	    }
	    else if((val.left == null && val.right != null) || (val.left != null && val.right == null)){
	    	parent = val.parent;
	    	if(parent.left != null && parent.left.data == val.data)
	    		if(parent.left.left == null){
	    			parent.left = val.right;
	    			val.right.parent = parent;
	    		}	
	    		else{
	    			parent.left = val.left;
	    			val.left.parent = parent;
	    		}	
	    	else if(parent.right != null && parent.right.data == val.data)
	    		if(parent.right.right == null){
	    			parent.right = val.left;
	    			val.left.parent = parent;
	    		}	
	    		else{
	    			parent.right = val.right;
	    			val.right.parent = parent;
	    		}
	    }	
	    else{
	    	parent = val.parent;
	    	if(parent.left != null && parent.left.data == val.data){
	    		min = minValue(val.right);
	    		parent.left = min;
	    		min.parent = parent;
	    	}	
	    	else if(parent.right != null && parent.right.data == val.data){
	    		min = minValue(val.right);
	    		parent.right = min;
	    		min.parent = parent;
	    	}
	    }
	}
	
	public Node getPredecessor(Node current){
		if(current.left != null){                                   //returns predecessor of node right before given value, in order trav.
			return maxValue(current.left);
		}
		
		Node parent = current.parent;
		if(current.data == minValue(current).data){
			System.out.println(current.data + " has no predecessor");
			return null;
		}	
		else{
			while(parent != null && current == parent.left){
				current = parent;
				parent = parent.parent;
			}
			return parent;
		} 
	}
	
	public Node getSuccessor(Node current){
		if(current.right != null){                                  //returns node that appears right after given value, in order trav.
			return minValue(current.right);
		}
		
		Node parent = current.parent;
		if(current.data == maxValue(current).data){
			System.out.println(current.data + " does not have a successor");
			return null;
		}	
		else{
			while(parent != null && current == parent.right){
				current = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	public void preOrderTraversal(Node current){
		if(current == null)                                         //takes in a node and prints pre-order-traversal
			return;
		System.out.print(" " + current.data);
		preOrderTraversal(current.left);
		preOrderTraversal(current.right);
	}
	
	public void inOrderTraversal(Node current){
		if(current == null)                                         //takes in a node and prints in-order-traversal
			return;
		inOrderTraversal(current.left);
		System.out.print(" " + current.data);
		inOrderTraversal(current.right);
	}
	
	public void postOrderTraversal(Node current){
		if(current == null)                                         //takes in a node and prints post-order-traversal
			return;
		postOrderTraversal(current.left);
		postOrderTraversal(current.right);
		System.out.print(" " + current.data);
	}
	
	public Node maxValue(Node maxVal){	
		Node current = maxVal;                                      //returns max value in tree of a given node
		while(current.right != null){
			current = current.right;
		}
		return current;
	}
	
	public Node minValue(Node minVal){
		Node current = minVal;                                      //returns min value in tree of given node
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
	public Node search(int value){
		Node temp = root;
		while(true){
	   		    if(temp.data == value)                          //searches for a node in the BST
					return temp;
				else if((value < temp.data && temp.left != null))
					temp = temp.left;
				else if((value > temp.data && temp.right != null))
					temp = temp.right;
				else{
					return null;
				}
			}
	}	
		
		
	public String toString(Node x){                                     //toString of a node
		String node = "" + x.data;
		return node;
	}
	
	private class Node{
	    Node left;
		Node right;
		Node parent;                                                //node class that takes in a int, also uses left, right, data, and parent.
		int data;
		
		public Node(int value){
			   data = value;
			   
		}
	}
}

