/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project3;

/**
 *
 * @author mrfre
 */
//////////////////////////////////////////////////////////////////////////////
public class DoublyLinkedList {
   Node first;

//---------------------------------------------------------------------------   
   public DoublyLinkedList(){
      first = null;                                                 //initializes the doubly linked list
   }   
//--------------------------------------------------------------------------- 

//---------------------------------------------------------------------------   
   public void add(int x){
      if(first == null){
         Node newNode = new Node(x);                                //creates a new node in the linked list with a prev and next reference.
         first = newNode;  
      }
      else{
         Node newNode = new Node(x);
         first.prev = newNode;
         newNode.next = first;
         first = newNode;
      }
   }
//---------------------------------------------------------------------------

//---------------------------------------------------------------------------   
   public void insertionSort(){  
      Node iterator = first.next;  
      Node p1 = iterator;
      Node p2 = iterator.prev;
      while(iterator != null){                                      //iterates through the linked list looking for next node values that are smaller than the prev
         if(p2.data < p1.data){                                     //node values. If found looks for where the next node should be located, and inserts in its proper
            iterator = iterator.next;                               //location.
            p1 = iterator;
            p2 = iterator.prev;
         } 
         else{
            while(p2.prev != null && p1.data < p2.data){
               p2 = p2.prev;    
            }
            if(p1.data > p2.data){
               Node temp = iterator.next;              
               insertNode(p1, p2);               
               iterator = temp.prev;               
            }
         }
         p1 = iterator;
         p2 = iterator.prev;
      }
   }
//---------------------------------------------------------------------------

//---------------------------------------------------------------------------
   public void print()
   {
      Node current = first;
      while (current != null)
      {
          System.out.println(current.data);
          current = current.next;
      }
   }
//---------------------------------------------------------------------------   
   
//---------------------------------------------------------------------------   
   public void insertNode(Node nodeInsert, Node reference){
//      Node temp1 = reference.next;    
//      Node insert = nodeInsert;                                    //inserts node in its proper location given the node to inserted, and a reference to the node before it
//      insert.next = temp1;
//      temp1.prev = insert; 
//      reference.next = insert; 
//      insert.prev = reference;

      Node insNext = nodeInsert.next;
      Node insPrev = nodeInsert.prev;
      Node refNext = reference.next;
      
      reference.next = nodeInsert;
      nodeInsert.prev = reference;     
       
      nodeInsert.next = refNext;
      refNext.prev = nodeInsert;
      
      insPrev.next = insNext;
   }    
//---------------------------------------------------------------------------
  
//---------------------------------------------------------------------------
   public void testInsertNode()
   {
       Node insert = first.next.next;
       Node ref = first;
       insertNode(insert, ref);
   }
//---------------------------------------------------------------------------
   
//////////////////////////////////////////////////////////////////////////////   
   private class Node{
      private int data;
      public Node next;
      public Node prev;
      
      public Node(int x){
         this.data = x;     
      }
   }
//////////////////////////////////////////////////////////////////////////////   
}
//////////////////////////////////////////////////////////////////////////////

