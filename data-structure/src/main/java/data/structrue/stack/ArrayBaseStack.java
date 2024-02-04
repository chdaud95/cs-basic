package data.structrue.stack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayBaseStack<T> {

  T[] array;

  int topIndex;

  public ArrayBaseStack(T[] array) {
    this.array = array;
    topIndex = -1;
  }

  boolean isEmpty(){
    if(topIndex == -1){
      return true;
    }else{
      return false;
    }
  }

  void push(T data){
    if(topIndex + 1 >= array.length) {
      log.error("더 이상 데이터를 추가할 수 없습니다.");
      return;
    }

    array[++topIndex] = data;
  }

  T pop(){
    if(isEmpty()){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }

    return array[topIndex--];
  }

  T peek(){
    if(isEmpty()){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    return array[topIndex];
  }
}
