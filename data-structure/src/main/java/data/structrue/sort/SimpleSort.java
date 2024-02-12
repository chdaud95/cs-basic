package data.structrue.sort;

public class SimpleSort {

  static void bubbleSort(int[] arr){
    int i , j;
    int temp;
    int n = arr.length;

    for (i = 0 ; i < n - 1 ; i++){
      for( j = 0 ; j < (n - i) - 1 ; j++){
        if(arr[j] > arr[j+1]){
          temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  static void selectSort(int[] arr){
    int i , j;
    int temp;
    int n = arr.length;
    int maxIdx;
    for( i = 0 ; i < n - 1 ; i++){
      maxIdx = i;
      for(j = i+1 ; j < n ; j++){
        if(arr[j] > arr[maxIdx]){
          maxIdx = j;
        }
      }
      temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;
    }
  }

  static void insertionSort(int[] arr){
    int i , j ;
    int temp;
    int n = arr.length;

    for( i = 1 ; i < n ; i++){
      temp = arr[i];
      for(j = i-1 ; j >= 0 ; j--){
        if(temp < arr[j]){
          arr[j+1] = arr[j];
        }else break;
      }
      arr[j+1] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 2, 4, 1};

    int i ;

    bubbleSort(arr);
    for(i = 0 ; i <arr.length ; i++){
      System.out.println(arr[i]);
    }

    int[] arr2 = {3,4,2,1};

    selectSort(arr2);
    for(i = 0 ; i <arr2.length ; i++){
      System.out.println(arr[i]);
    }

    int[] arr3 = {5,3,2,4,1};

    insertionSort(arr3);
    for(i = 0 ; i <arr3.length ; i++){
      System.out.println(arr3[i]);
    }

  }
}
