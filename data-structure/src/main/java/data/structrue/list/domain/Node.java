package data.structrue.list.domain;

import lombok.Data;

@Data
public class Node<T> {
  Node<T> next;
  Node<T> prev;
  T data;

  public Node() {
  }

  public Node(T data) {
    this.next = null;
    this.prev = null;
    this.data = data;
  }
}
