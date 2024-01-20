package data.structrue.list;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CircularLinkedList<T> {

  Node<T> tail;
  Node<T> cur;
  Node<T> before;

  int numOfData;

  public CircularLinkedList() {
    this.tail = null;
    this.cur = null;
    this.before = null;
    numOfData = 0;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);
    if(tail == null) {
      tail = newNode;
      tail.setNext(newNode);
    }else{
      newNode.setNext(tail.getNext());
      tail.setNext(newNode);
      tail = newNode;
    }
    numOfData++;
  }

  void frontInsert(T data){
    Node<T> newNode = new Node<>(data);
    if(tail == null){
      tail = newNode;
      tail.setNext(newNode);
    }else{
      newNode.setNext(tail.getNext());
      tail.setNext(newNode);
    }

    numOfData++;
  }

  T first(){
    if(tail == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    cur = tail.getNext();
    before = tail;
    return cur.getData();
  };

  T next(){
    if(tail == null || cur == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    before = cur;
    cur = cur.getNext();
    return cur.getData();
  }

  T remove(){
    Node<T> pos = cur;
    T data = pos.getData();
    if(cur == tail){
      if(tail == tail.getNext()){
        tail = null;
      }else{
        tail = before;
      }
    }
    before.setNext(cur.getNext());
    cur = before;
    numOfData--;

    return data;
  }

  int count(){
    return numOfData;
  }

  void allPrint(){
    if(tail == null){
      log.error("저장된 데이터가 없습니다.");
      return;
    }

    T first = first();
    if(first != null){
      log.info("첫번째 값 : {}", first);
      T next ;
      for( int i = 0 ; i < count() - 1 ; i++){
        next = next();
        if(next != null){
          log.info("다음 값 : {}",next);
        }
      }


    }

  }

}
