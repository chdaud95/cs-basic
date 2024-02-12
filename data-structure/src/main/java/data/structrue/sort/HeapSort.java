package data.structrue.sort;

import data.structrue.heap.UsefulHeap;

public class HeapSort {

  static void heapSort(Integer[] arr){
    Integer[] init = new Integer[100];
    UsefulHeap<Integer> heap = new UsefulHeap<>((o1,o2) -> {
      return (o2-o1);
    },init);
    int i ;
    for( i = 0 ; i < arr.length ; i++){
      heap.insert(arr[i]);
    }
    for( i = 0 ; i < arr.length ; i++){
       arr[i] = heap.delete();
    }
  }
  public static void main(String[] args) {
    Integer[] arr = {3,4,2,1};
    int i;

    heapSort(arr);

    for(i = 0 ;i <arr.length ;i++){
      System.out.println(arr[i]);
    }


  }
}
