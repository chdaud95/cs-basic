package data.structrue.queue;

public class ArrayQueueMain {
  public static void main(String[] args) {
    Integer[] arr = new Integer[6];
    ArrayQueue<Integer> queue = new ArrayQueue<>(arr);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    while(!queue.isEmpty()){
      System.out.println(queue.dequeue());
    }

  }
}
