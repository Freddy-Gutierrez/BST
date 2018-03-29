
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project3;

import java.util.Arrays;

/**
 *
 * @author mrfre
 */
///////////////////////////////////////////////////////////////////////////////
public class MergeSort {
    
   private int[] array;
   private int[] tempArray;
   int[] sortedArray;
   private int length;
   
//---------------------------------------------------------------------------   
   public MergeSort(int[] x){
      this.array = x;                                           
      this.length = x.length;                                                   //initializes my array with the array that is passed through from the driver.
      int[] tempArray = new int[x.length];                                      //Prints original array, calls mergeSort method, prints sorted array
      System.out.println("MergeSort");
      System.out.println("Original Array: ");
      System.out.println(Arrays.toString(x));
      mergeSort(array, tempArray, 0, length-1);
      System.out.println("Sorted Array: ");
      sortedArray = Arrays.copyOf(tempArray, tempArray.length);
      System.out.println(Arrays.toString(sortedArray));
      System.out.println();
   }
//---------------------------------------------------------------------------
   
//---------------------------------------------------------------------------   
   private void mergeSort(int [] array, int [] tempArray, int first, int last){     
      if(first < last){
         int mid = first + (last - first)/ 2;                                   //Splits array down the middle until it reaches its base case, then calls merge to 
         mergeSort(array, tempArray, first, mid);                               //begin merging arrays in there proper order
         mergeSort(array, tempArray, mid + 1, last);
         merge(array, tempArray, first, mid, last);
      }       
   }
//---------------------------------------------------------------------------

//---------------------------------------------------------------------------   
   private void merge(int[] array, int[] tempArray, int first, int mid, int last){
      int startHalfOne = first; 
      int endHalfOne = mid;
      int startHalfTwo = mid +1;
      int endHalfTwo = last;                                                    //Splits array into a half smaller than the mid, and a half bigger than the mid.
      int index = first;                                                        //Then compares the indicies of each subarray, copying over the smaller value to 
      while(startHalfOne <= endHalfOne && startHalfTwo <= endHalfTwo){          // the tempArray. Lastly, copies tempArray values to original array so proper values
         if(array[startHalfOne] <= array[startHalfTwo]){                        // are compared in merge method.
            tempArray[index] = array[startHalfOne];
            startHalfOne++;
         }    
         else{
            tempArray[index] = array[startHalfTwo];
            startHalfTwo++;
         }
         index++;
      }   
      while(startHalfOne <= endHalfOne){
         tempArray[index] = array[startHalfOne];
         index++;
         startHalfOne++;
      }    
      while(startHalfTwo <= endHalfTwo){
         tempArray[index] = array[startHalfTwo];
         index++;
         startHalfTwo++;
      }
      
       for (int i = first; i <= last; i++) {
           array[i] = tempArray[i];
           
       }
   }
//---------------------------------------------------------------------------   
}
///////////////////////////////////////////////////////////////////////////////