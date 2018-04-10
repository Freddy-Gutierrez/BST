/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
/**
 *
 * @author mrfre
 */
///////////////////////////////////////////////////////////////////////////////
public class QuickSort {
   private static int[] myArray;
   private static int length;
   
//---------------------------------------------------------------------------   
   public QuickSort(int[] input){
      this.myArray = input;                                 //constructor that initialzied my global array from the driver along with some variables
      this.length = input.length;                           //Makes quickSort call, prints original array, then sorted array
      System.out.println("QuickSort:");
      System.out.println("Original Array: ");
      System.out.println(Arrays.toString(myArray)); 
      int first = 0;
      int last = myArray.length - 1;
      quickSort(first, last);
      System.out.println("Sorted Array: ");
      System.out.println(Arrays.toString(myArray));   
      System.out.println();
   }   
//---------------------------------------------------------------------------
   
//---------------------------------------------------------------------------   
   private void quickSort(int first, int last){
      if(last - first <= 0){
         return;                                                        //array already sorted    
      }  
      else{
         int pivot = myArray[0]; 
         int pivotPoint = partition(first, last);                       //performs recursive quickSort calls until base case is reached, then goes back through stack 
         quickSort(first, pivotPoint-1);                                //and performs second recursive call.
         quickSort(pivotPoint+1, last);
      }
   }
//---------------------------------------------------------------------------
   
//---------------------------------------------------------------------------   
   private int partition(int first, int last){
      int pivotIndex = first; 
      int index = myArray.length - 1;                                   //Partitions the array about the pivot which is chosen to be the first array of the index
      int tempSwitch;                                                   //All values smaller than the pivot are to its left, all values bigger are to its right. Returns index
      while(true){
         while(myArray[pivotIndex] < myArray[index])
            index--;
         if(myArray[pivotIndex] > myArray[index]){
            swap(pivotIndex, index);
            tempSwitch = pivotIndex;
            pivotIndex = index; 
            index = tempSwitch;    
         }   
         while(myArray[pivotIndex] > myArray[index])
            index++;
         if(myArray[pivotIndex] < myArray[index]){
            swap(pivotIndex, index);
            tempSwitch = pivotIndex;
            pivotIndex = index; 
            index = tempSwitch;
         }   
         if(myArray[index] == myArray[pivotIndex]){
            break;
         }   
      }
      return index; 
   }
//---------------------------------------------------------------------------

//---------------------------------------------------------------------------   
   private void swap(int i, int j){
      int tempVal = myArray[i];                                     //performs a swap when it is called from partition method
      myArray[i] = myArray[j];
      myArray[j] = tempVal;
      
   }
//---------------------------------------------------------------------------   
}
///////////////////////////////////////////////////////////////////////////////