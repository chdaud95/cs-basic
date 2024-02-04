package data.structrue.stack;

import data.structrue.list.domain.Node;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListBaseStack<T> {

  Node<T> head;

  public ListBaseStack() {
    this.head = null;
  }

  public boolean isEmpty(){
    return this.head == null;
  }

  void push(T data){
    Node<T> newNode = new Node<>(data);

    newNode.setNext(head);
    head = newNode;
  }

  T pop(){
    if(isEmpty()){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    Node<T> ref = head;
    T data = ref.getData();
    head = head.getNext();
    return data;
  }

  T peek(){
    if(isEmpty()){
      log.error("저장된 데이터가 없습니다.");
      return null;
    }
    return head.getData();
  }
}
