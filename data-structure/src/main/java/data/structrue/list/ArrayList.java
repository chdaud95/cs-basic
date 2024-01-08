package data.structrue.list;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayList<T> {

  public T[] array;
  int numOfData;
  int curPosition;

  public ArrayList(T[] array) {
    this.array = array;
    this.numOfData = 0;
    this.curPosition = -1;
  }

  public void insert(T data){

    if(numOfData >= array.length) {
      log.error("데이터를 더이상 저장할 수 없습니다.");
      return;
    }
    array[numOfData++] = data;
  }

  public T first(){
    if(numOfData == 0) {
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    curPosition = 0;
    return array[curPosition];
  }

  public T next(){
    if(curPosition >= array.length - 1 ){
      log.error("다음 데이터가 없습니다.");
      return null;
    }
    return array[++curPosition];
  }

  public T remove(){
    int pos = curPosition;
    int num = numOfData;
    T removeData = array[curPosition];

    for( int i = pos ; i< num - 1 ; i++){
      array[i] = array[i+1];

      //마지막 데이터를 땡겨왔으니 메모리에서 제거해줘야한다.
      if( i == num - 2 ){
        array[i+1] = null;
      }
    }

    numOfData--;
    curPosition--;
    return removeData;
  }


}
