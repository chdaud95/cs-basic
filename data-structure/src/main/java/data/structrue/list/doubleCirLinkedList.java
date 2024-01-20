package data.structrue.list;

import data.structrue.list.domain.Node;

public class doubleCirLinkedList<T> {

  Node<T> head;
  Node<T> cur;

  int numOfData;

  public doubleCirLinkedList() {
    this.head = null;
    this.cur = null;
  }

  void insert(T data){
    Node<T> newNode = new Node<>(data);

    newNode.setNext(head);
    if(head != null){
      head.setPrev(newNode);
    }
    newNode.setPrev(null);
    head = newNode;
    numOfData++;
  }

  T first(){
    if(head == null) return null;
    cur = head;
    return cur.getData();
  }

  T next(){
    if(cur == null || cur.getNext() == null) return null;
    cur = cur.getNext();
    return cur.getData();
  }

  T previous(){
    if(cur == null || cur.getPrev() == null) return null;
    cur = cur.getPrev();
    return cur.getData();
  }

  int count(){
    return numOfData;
  }

}
