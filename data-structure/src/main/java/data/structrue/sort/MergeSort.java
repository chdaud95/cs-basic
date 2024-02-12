package data.structrue.sort;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = {3,2,4,1,7,6,5};
    int i;
    mergeSort(arr,0,arr.length-1);

    for(i = 0 ; i<arr.length ;i++){
      System.out.println(arr[i]);
    }
  }
  static void mergeSort(int[] arr,int left , int right){
    int mid;

    if(left < right){
      mid = (left+right)/2;
      mergeSort(arr,left,mid);
      mergeSort(arr,mid+1,right);

      mergeTwoArea(arr,left,mid,right);
    }
  }

  static void mergeTwoArea(int[] arr,int left,int mid, int right){

    int fIdx = left;
    int rIdx = mid+1;
    int i ;
    int[] sortArr = new int[right+1];
    int sIdx = left;

    while(fIdx <= mid && rIdx <=right){
      if(arr[fIdx] <= arr[rIdx]){
        sortArr[sIdx] = arr[fIdx++];
      }else{
        sortArr[sIdx] = arr[rIdx++];
      }
      sIdx++;
    }

    if(fIdx > mid){
      for(i=rIdx ; i<=right ; i++,sIdx++){
        sortArr[sIdx] = arr[i];
      }
    }else{
      for(i=fIdx ; i<= mid; i++,sIdx++){
        sortArr[sIdx] = arr[i];
      }
    }

    for(i = left ; i<=right ; i ++){
      arr[i] = sortArr[i];
    }
  }
}
