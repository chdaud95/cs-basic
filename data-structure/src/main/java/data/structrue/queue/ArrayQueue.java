package data.structrue.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayQueue<T> {

  T[] arr;
  int front;
  int rear;

  public ArrayQueue(T[] arr) {
    this.arr = arr;
    this.front = 0;
    this.rear = 0;
  }

  public boolean isEmpty(){
    return front == rear;
  }

  public void enqueue(T data){
    if(nextPosIdx(rear) == front){
      throw new IllegalStateException("데이터가 꽉 찼습니다.");
    }
    rear = nextPosIdx(rear);
    arr[rear] = data;
  }

  public T dequeue(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    front = nextPosIdx(front);
    T data = arr[front];
    arr[front] = null;
    return data;

  }

  public T peek(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    return arr[nextPosIdx(front)];
  }

  private int nextPosIdx(int pos){
    if(pos == arr.length - 1 ){
      return 0;
    }else{
      return pos + 1;
    }
  }
}
