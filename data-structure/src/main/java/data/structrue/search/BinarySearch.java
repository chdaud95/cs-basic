package data.structrue.search;

import lombok.extern.slf4j.Slf4j;

/*
* 이진 탐색
* */
@Slf4j
public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {1,2,3,7,9,12,21,23,27};
    int target = 9;

    int result = binarySearch(arr, target);

    log.info("이진탐색 타겟 인덱스 : {}",result);

  }

  static int binarySearch(int[] arr,int target){

    int start = 0;
    int end = arr.length - 1;
    int mid;
    int count = 0;

    while(start <= end){
      count++;
      mid = (start+end)/2;
      if(arr[mid] == target){
        log.info("연산 횟수 : {}",count);
        return mid;
      }else if( arr[mid] > target){
        end = mid - 1;
      }else{
        start = mid + 1;
      }
    }
    log.info("연산 횟수 : {}",count);
    return -1;
  }

}
