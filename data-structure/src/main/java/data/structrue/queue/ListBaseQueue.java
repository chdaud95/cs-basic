package data.structrue.queue;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListBaseQueue<T> {
  Node<T> front;
  Node<T> rear;

  public ListBaseQueue() {
    this.front = null;
    this.rear = null;
  }

  public boolean isEmpty(){
    return front == null;
  }

  public void enqueue(T data){
    Node<T> newNode = new Node<>(data);
    if(isEmpty()){
      front = newNode;
      rear = newNode;
    }else{
      rear.setNext(newNode);
      rear = newNode;
    }
  }

  public T dequeue(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }

    T data = front.getData();
    front = front.getNext();

    return data;
  }

  public T peek(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }

    return front.getData();
  }
}
