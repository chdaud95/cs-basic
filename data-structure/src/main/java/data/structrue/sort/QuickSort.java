package data.structrue.sort;

import java.awt.print.Pageable;

public class QuickSort {

  static void swap(int[] arr, int idx1, int idx2){
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  static int partition(int[] arr, int left ,int right){
    int pivot = left;
    int low = left + 1;
    int high = right;

    while(low <= high){
      while(low <= right && arr[pivot] >= arr[low]){
        low++;
      }
      while(high >= left+1 && arr[pivot] <= arr[high]){
        high--;
      }

      if(low <= high){
        swap(arr,low,high);
      }
    }

    swap(arr,pivot,high);
    return high;
  }

  static void quickSort(int[] arr, int left, int right){
    if(left <= right){
      int partition = partition(arr, left, right);
      quickSort(arr,left,partition-1);
      quickSort(arr,partition+1,right);
    }
  }

  public static void main(String[] args) {
    int[] arr={3,2,4,15,6,433,32,4,102,42,4};
    quickSort(arr,0,arr.length-1);

    for(int i = 0 ; i <arr.length ; i++){
      System.out.println(arr[i]);
    }
  }
}
