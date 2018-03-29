/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project4;

import java.util.Scanner;

/**
 *
 * @author mrfre
 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////

//Purpose: Demonstrate ability to implement a FIFO and Priority queue through the use of arrays or a doubly linked list.  
public class AssignmentQueueDriver<T> {  
//------------------------------------------------------------------------------------------------    
   public static void main(String[] args){
      ArrayQueue<Integer> myArray = new ArrayQueue<Integer>(); 
      DoublyLinkedListQueue<Integer> myDLL = new DoublyLinkedListQueue<Integer>();
      PriorityQueue<Assignment> PQ = new PriorityQueue<Assignment>();
      
      
      Scanner kb = new Scanner(System.in);
      int answerTwo;
      int data;
      String assignmentName;
      int daysUntilDue;
      int value;
      
      System.out.println("What type of queue would you like(Enter number 1-3): ");
      System.out.println("1. Array FIFO Queue");
      System.out.println("2. Linked List FIFO Queue");
      System.out.println("3. Priority Queue");
      System.out.print("Enter option: ");
      int answerOne = kb.nextInt();
      
      do{
         System.out.println("What would you like to do(Enter number 1-3): ");
         System.out.println("1. Add item to queue");
         System.out.println("2. Dequeue");
         System.out.println("3. Quit");
         System.out.print("Enter option: ");
         answerTwo = kb.nextInt();
         if(answerOne == 1 && answerTwo == 1){
            System.out.print("Enter item you would like to add: ");
            data = kb.nextInt();
            myArray.enqueue(data);
         }
         if(answerOne == 1 && answerTwo == 2){
            myArray.dequeue();
         }
         if(answerOne == 1 && answerTwo == 3){
            System.exit(0);
         }
         if(answerOne == 2 && answerTwo == 1){
            System.out.print("Enter item you would like to add: ");
            data = kb.nextInt();
            myDLL.enqueue(data);       
         }
         if(answerOne == 2 && answerTwo == 2){
            myDLL.dequeue();
         }
         if(answerOne == 2 && answerTwo == 3){
            System.exit(0); 
         }
         if(answerOne == 3 && answerTwo == 1){
            System.out.print("Enter the name of the assignment: ");
            kb.nextLine();
            assignmentName = kb.nextLine();
            System.out.print("Enter value of assignment: ");
            value = kb.nextInt();
            System.out.print("Enter days until due: ");
            daysUntilDue = kb.nextInt();
            Assignment assignment = new Assignment(assignmentName, value, daysUntilDue);
            PQ.enqueue(assignment);
         }
         if(answerOne == 3 && answerTwo == 2){
            Assignment assignment = PQ.dequeue();
            if(assignment != null)
               assignment.toString();
         }
         if(answerOne == 3 && answerTwo == 3){
            System.exit(0);    
         }
      }while(answerTwo != 3);         
   }  
//------------------------------------------------------------------------------------------------   
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////