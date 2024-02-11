package data.structrue.heap;

import lombok.Data;

@Data
public class Priority {
  private int pri;

  public Priority(int pri) {
    this.pri = pri;
  }
}
