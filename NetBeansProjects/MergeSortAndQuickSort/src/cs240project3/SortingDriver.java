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
///////////////////////////////////////////////////////////////////////////////

//purpose: Demonstrate ability to sort an array recursively through the use of MergeSort and QuickSort
public class SortingDriver {  
//---------------------------------------------------------------------------    
   public static void main(String args[]){  
      int[] x = {32,85,18,99,100};
      int[] y = {32,85,18,99,100};
      
      QuickSort myQS = new QuickSort(x);
      MergeSort myMS = new MergeSort(y);

   }
//---------------------------------------------------------------------------   
}
///////////////////////////////////////////////////////////////////////////////