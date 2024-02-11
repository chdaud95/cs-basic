package data.structrue.heap;

import lombok.Data;

@Data
public class HeapElem<T> {

  private T data;
  private Priority priority;

  public HeapElem(T data, Priority priority) {
    this.data = data;
    this.priority = priority;
  }
}
