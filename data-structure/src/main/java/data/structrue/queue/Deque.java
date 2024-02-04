package data.structrue.queue;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Deque<T> {

  Node<T> front;
  Node<T> rear;

  public Deque() {
    this.front = null;
    this.rear = null;
  }

  public boolean isEmpty(){
    return front == null;
  }

  public void frontEnqueue(T data){
    Node<T> newNode = new Node<>(data);
    if(isEmpty()){
      rear = newNode;
    }else{
      front.setPrev(newNode);
    }
    newNode.setNext(front);
    front = newNode;
  }
  public void endEnqueue(T data){
    Node<T> newNode = new Node<>(data);

    if(isEmpty()){
      front = newNode;
    }else{
      rear.setNext(newNode);
    }
    newNode.setPrev(rear);
    rear = newNode;
  }

  public T frontDequeue(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    T data = front.getData();
    front = front.getNext();
    if(front == null){
      rear = null;
    }else{
      front.setPrev(null);
    }
    return data;
  }

  public T endDequeue(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    T data = rear.getData();
    Node<T> prev = rear.getPrev();
    rear = rear.getPrev();
    if(rear ==  null){
      front = null;
    }else{
      rear.setNext(null);
    }
    return data;
  }

  public T frontPeek(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    return front.getData();
  }

  public T endPeek(){
    if(isEmpty()){
      log.error("데이터가 없습니다.");
      return null;
    }
    return rear.getData();
  }
}
