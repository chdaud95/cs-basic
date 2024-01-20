package data.structrue.list;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbDummyLinkedList<T> {

  Node<T> head;
  Node<T> tail;
  Node<T> cur;

  int numOfData;

  public DbDummyLinkedList() {
    this.head = new Node<>();
    this.tail = new Node<>();

    this.head.setNext(tail);
    this.head.setPrev(null);
    this.tail.setNext(null);
    this.tail.setPrev(head);

    this.cur = null;
    numOfData = 0;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);

    tail.getPrev().setNext(newNode);
    newNode.setPrev(tail.getPrev());

    tail.setPrev(newNode);
    newNode.setNext(tail);

    numOfData++;
  }

  T first(){
    if(head.getNext() == tail) return null;
    cur = head.getNext();
    return cur.getData();
  }

  T next(){
    if(cur.getNext() == tail) return null;
    cur = cur.getNext();
    return cur.getData();
  }

  T previous(){
    if(cur.getPrev() == head) return null;
    cur = cur.getPrev();
    return cur.getData();
  }

  T remove(){
    if(cur == this.head) {
      log.error("삭제할 데이터가 없습니다.");
    }
    Node<T> ref = cur;
    T data = ref.getData();
    cur.getNext().setPrev(cur.getPrev());
    cur.getPrev().setNext(cur.getNext());

    cur = cur.getPrev();
    numOfData--;

    return data;
  }

  int count(){
    return numOfData;
  }

}
