/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project4;

import java.util.Arrays;

/**
 *
 * @author mrfre
 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class PriorityQueue<T> implements Queue<T>{
   T[] myArray;
   T data;
   int numEntries;
   private boolean initialized = false;
   private static final int MIN_DEFAULT_SIZE = 10;
   private static final int MAX_SIZE = 480;

//--------------------------------------------------------------------------------------------------------------------------------------              
   public PriorityQueue(){
      @SuppressWarnings("Unchecked")
      T[] temp = (T[])new Object[MIN_DEFAULT_SIZE];                  //Constructor that creates our array witht the default initial size, changes initialized to true, 
      myArray = temp;                                                  //and initializes numEntries variable(-1 means array is empty, 0 means there is one element in array)
      initialized = true;
      numEntries = -1;
   }
//--------------------------------------------------------------------------------------------------------------------------------------              
    
//--------------------------------------------------------------------------------------------------------------------------------------          
   public void checkInitialization(){                                     //checks to see if array is initialized properly
      if(!initialized){
         System.out.println("Array was not initialized properly");
         System.exit(0);
      }
   }
//--------------------------------------------------------------------------------------------------------------------------------------          
    
//--------------------------------------------------------------------------------------------------------------------------------------          
   private void ensureCapacity(){                      //Checks to see if Stack has any room to add an entry. If it doesn't, it doubles Stacks length, 
      if(numEntries == myArray.length-1){              //and ensures Stack's new length is less than the MAX CAP. Lastly copys the old Stack to a new Stack.  
        int newLength = (myArray.length)*2;
        checkCapacity(newLength);
        myArray = Arrays.copyOf(myArray, newLength);
       }    
   }
//--------------------------------------------------------------------------------------------------------------------------------------      
    
//--------------------------------------------------------------------------------------------------------------------------------------          
   private boolean checkCapacity(int length) {         //Checks to see if array lenth is less than MAX_CAPACITY
      if(length < MAX_SIZE)
         return true;
      else
         System.out.println("Growing array would exceed the max array size");    
         return false;
    }
//--------------------------------------------------------------------------------------------------------------------------------------      

//--------------------------------------------------------------------------------------------------------------------------------------   
    
   @Override
    public boolean enqueue(T anEntry) {
       ensureCapacity();
       if(numEntries < myArray.length){                         //adds entry to the back of the array
          myArray[numEntries+1] = anEntry;
          numEntries++;
          print();
          return true;
       }
       else
          return false;    
    }
//--------------------------------------------------------------------------------------------------------------------------------------    

//--------------------------------------------------------------------------------------------------------------------------------------    
    
   @Override
    public T dequeue() {
       if(isEmpty()){
          System.out.println("Queue already empty, nothing to dequeue");
          return null;
       }
       else{
          T[] temp = (T[]) new Object[numEntries + 1];
          for(int i = 0; i <= numEntries; i++)
          {
             temp[i] = myArray[i];
          }
          
          Arrays.sort(temp);
          int copyNumEntries = numEntries;       
          for(int i = 0; i <= numEntries; i++)
          {
             myArray[i] = temp[copyNumEntries];
             copyNumEntries--;
          }
          
          data = myArray[0];
          T[] temp2 = (T[]) new Object[myArray.length];           //all remaining elements to the left by one, and decrements the 
          int newIndex = 0;                                      // number of entries.
          for(int i = 1; i<myArray.length; i++){
             temp2[newIndex] = myArray[i];  
             newIndex++;
          }
          myArray = temp2;
          
          numEntries--;
          System.out.println(data);                              //Checks to see if there are elements in the queue to remove 
          return data;                                           //if there are, returns first element in the array, then shifts  
       }                                                         //all remaining elements to the left by one, and decrements the
    }
//--------------------------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------------------    
    
   @Override
    public boolean isEmpty() {
       if(numEntries == -1)
          return true;                                          //checks to see if there are an elements in the queue
       else
          return false;
    }
    
    public void print(){
       for(int i =0; i < myArray.length; i++){
          if(myArray[i] == null)
             break;
          else
             System.out.print(myArray[i]+ " ");
       }          
    }
//--------------------------------------------------------------------------------------------------------------------------------------       
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////