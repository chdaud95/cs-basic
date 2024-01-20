package data.structrue.list;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class LinkedList<T> {
  Node<T> head;
  Node<T> cur;
  Node<T> before;
  int numOfData;

  Comparator<T> comp;

  public LinkedList() {
    this.head = new Node<>();
    this.cur = null;
    this.before = null;
    this.comp = (a,b) -> {return 0;};
    numOfData = 0;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);

    //정렬문
    Node<T> point = head;

    while(point.getNext() != null && comp.compare(point.getNext().getData(),newNode.getData()) != 0){
      point = point.getNext();
    }

    newNode.setNext(point.getNext());
    point.setNext(newNode);
    numOfData++;
  }

  T first(){
    if(head.getNext() == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    before = head;
    cur = head.getNext();
    return cur.getData();
  }

  T next(){
    if(cur == null || cur.getNext() == null){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    before = cur;
    cur = cur.getNext();
    return cur.getData();
  }
  T remove(){
    T data = cur.getData();
    before.setNext(cur.getNext());
    cur = before;
    return data;
  }

  void setSortRule(Comparator<T> comp){
    this.comp = comp;
  }
}
