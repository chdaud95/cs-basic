package data.structrue.stack;

import data.structrue.list.CircularLinkedList;

public class CListBaseStack<T> {

  CircularLinkedList<T> list;

  public CListBaseStack() {
    list = new CircularLinkedList<>();
  }

  boolean isEmpty(){
    return list.count() == 0;
  }

  void push(T data){
    list.frontInsert(data);
  }

  T pop(){
    T data = list.first();
    list.remove();
    return data;
  }

  T peek(){
    T data = list.first();

    return data;
  }
}
