/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project4;

/**
 *
 * @author mrfre
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class DoublyLinkedListQueue<T> implements Queue<T> {
   Node first;
   Node last;
   T data;
   
//------------------------------------------------------------------------------------   
   @Override
   public boolean enqueue(T anEntry) {
      if(first == null){
         Node newNode = new Node(anEntry);                                //creates a new node in the linked list with a prev and next reference.
         first = newNode;  
         print();
         System.out.println();
      }
      else{
         Node newNode = new Node(anEntry);
         first.prev = newNode;
         newNode.next = first;
         first = newNode;
         print();
         System.out.println();
      }   
      return true;
   }
//------------------------------------------------------------------------------------   

//------------------------------------------------------------------------------------   
   @Override
   public T dequeue() {
     Node iterator = first;                                       //removes and return the data in the linked list
     if(isEmpty()){
        System.out.println("Queue is already empty");   
        return null;
     }   
     if(iterator.next == null){
        data = (T)iterator.data;
        first = null;
        System.out.println(data);
        System.out.println();
        return data;
      }
      while(iterator != null){     
         if(iterator.next == null){
            data = (T)iterator.data;     
            iterator.prev.next = null;
         }       
         iterator = iterator.next;
      }
      System.out.println(data);
      System.out.println();
      return data;
   }
//------------------------------------------------------------------------------------   
   
//------------------------------------------------------------------------------------
   @Override
   public boolean isEmpty() {
      if(first == null)                                                  //checks to see if linked list is empty
         return true;          
      else
         return false;
   }
   
   public void print(){
      Node iterator = first;
      System.out.print("Current Queue: ");
      while(iterator != null){
         System.out.print(iterator.data + " ");
         iterator = iterator.next;
      }   
   }
//------------------------------------------------------------------------------------
   
/////////////////////////////////////////////////////////////////////////////////////
   private class Node<T>{
      T data;
      public Node next;
      public Node prev;
      
      public Node(T anEntry){
         this.data = anEntry; 
      }
   }
////////////////////////////////////////////////////////////////////////////////////
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////