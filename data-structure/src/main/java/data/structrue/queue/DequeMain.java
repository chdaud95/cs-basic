package data.structrue.queue;

public class DequeMain {
  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();

    deque.frontEnqueue(3);
    deque.frontEnqueue(2);
    deque.frontEnqueue(1);
    deque.endEnqueue(4);
    deque.endEnqueue(5);
    deque.endEnqueue(6);

    while(!deque.isEmpty()){
      System.out.println(deque.frontDequeue());
    }

    deque.frontEnqueue(3);
    deque.frontEnqueue(2);
    deque.frontEnqueue(1);
    deque.endEnqueue(4);
    deque.endEnqueue(5);
    deque.endEnqueue(6);

    while(!deque.isEmpty()){
      System.out.println(deque.endDequeue());
    }
  }
}
