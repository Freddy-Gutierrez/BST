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
import java.util.Scanner;
public class BSTDriver {

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String command;
		int commandVal = 0;
		String [] input;
		String[] strValues;
		int [] inputVal;
		int [] values;
		
		System.out.print("Please enter the initial sequence of values: ");
		String initial = kb.nextLine();
		strValues = initial.split(" ");						//splits string using spaces, int[] then runs through string[] array parsing string to an int
		values = new int[strValues.length];
		for(int i = 0; i <strValues.length; i++){
			values[i] = Integer.parseInt(strValues[i]);	
		}
		
		BST bst = new BST(values[0]);
		for(int i = 1; i<values.length; i++){					//uses int[] from above to insert values into BST
			bst.insert(values[i]);
		}
		
		System.out.print("Pre-Order:"); bst.preOrderTraversal(bst.root);
		System.out.println();
		System.out.print("In-Order:"); bst.inOrderTraversal(bst.root);		//prints three traversals required using original input
		System.out.println();
		System.out.print("Post-Order:"); bst.postOrderTraversal(bst.root);
		System.out.println();
		
		do{
		   System.out.print("Command? ");					//loops at menu until e or E is entered
		   command = kb.nextLine();
		   input = command.split(" ");
		   inputVal = new int [input.length];
		   for(int i = 0; i <inputVal.length; i++){
			   if(i == 0)
				   inputVal[0] = 0;
			   else{
				   inputVal[i] = Integer.parseInt(input[i]);
				   commandVal = inputVal[i];
			   }
		   }
		
		   if(command.charAt(0) == 73 || command.charAt(0) == 105){             //ascii values of i
				   if(bst.search(commandVal) == null){
					   bst.insert(commandVal);
					   System.out.print("In-order:");
					   bst.inOrderTraversal(bst.root);
					   System.out.println();
				   }
				   else
					   System.out.println(commandVal + " already exist, ignore.");   
		   }
		   else if(command.charAt(0) == 68 || command.charAt(0) == 100){    
			   	if(bst.search(commandVal) != null){			//ascii values of d
			   		System.out.print("In-order:");
			   		bst.delete(commandVal);
					bst.inOrderTraversal(bst.root);
					System.out.println();
			   	}
			   	else
			        System.out.println("Value does not exist in BST");  
		   }
		   else if(command.charAt(0) == 80 || command.charAt(0) == 112){    	//ascii values of p
				   if(bst.search(commandVal) != null){
					   if(bst.getPredecessor(bst.search(commandVal)) == null)
						   System.out.print("");
					   else
						   System.out.println(bst.toString(bst.getPredecessor(bst.search(commandVal))));	   
				   } 
				   else
					   System.out.println("Value does not exist in BST");		//if statement to check if value exist in BST	   
		   }
		   else if(command.charAt(0) == 83 || command.charAt(0) == 115){   		  	//ascii values of s
				   if(bst.search(commandVal) != null){
					   if(bst.getSuccessor(bst.search(commandVal)) == null)
						   System.out.print("");
					   else
						   System.out.println(bst.toString(bst.getSuccessor(bst.search(commandVal))));
				   } 
				   else
					   System.out.println("Value does not exist in BST");		//if statement to check if value exist in BST	   
		   }
		   else if(command.charAt(0) == 69 || command.charAt(0) == 101){     			//ascii values of e
			  System.out.println("Thank you for using my program!"); 
			  System.exit(0);
		   }
		   else if(command.charAt(0) == 72 || command.charAt(0) == 104){    			 //ascii values of h
		      System.out.println(" I Insert a value");
		      System.out.println(" D Deleted a value");
		      System.out.println(" P Find predecessor");
		      System.out.println(" S Find successor");
		      System.out.println(" E Exit the program");
		      System.out.println(" H Display this message");
		   }
		   else{
		      System.out.println("Please enter a valid command, or enter H for help");
		   }
		}while(command.charAt(0) != 69 || command.charAt(0) != 101); 
	}
}

