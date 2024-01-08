package data.structrue.list;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedList<T> {
  Node<T> head;
  Node<T> tail;
  Node<T> cur;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.cur = null;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);

    if(head == null){
      head = new Node<>();
      head.setNext(newNode);
    }else{
      tail.setNext(newNode);
    }
    tail = newNode;
  }

  T first(){
    if(head == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    cur = head.getNext();
    T data = cur.getData();
    cur = cur.getNext();
    return data;
  }

  T next(){
    if(head == null || cur == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }

    T data = cur.getData();
    cur = cur.getNext();
    return data;
  }

  T remove(){
    if(head == null || cur == null){
      log.error("삭제할 데이터가 없습니다.");
      return null;
    }
    return null;
  }
}
