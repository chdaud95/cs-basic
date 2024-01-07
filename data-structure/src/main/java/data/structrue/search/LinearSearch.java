package data.structrue.search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinearSearch {

  public static void main(String[] args) {

    int[] arr ={3,5,2,4,9};
    int target = 5;
    int result = linearSearch(arr, target);

    log.info("타켓 위치 : {}", result);
  }

  static int linearSearch(int[] arr, int target) {
    int i;
    int length = arr.length;
    int count = 0 ;
    for(i = 0 ; i < length ; i++){
      count++; //연산 횟수 측정
      if(arr[i] == target){
        log.info("연산 횟수 : {}",count);
        return i;
      }
    }

    log.info("연산 횟수 : {}",count);

    return -1;
  }



}
