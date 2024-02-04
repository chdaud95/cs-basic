package data.structrue.queue;

public class ListBaseQueueMain {
  public static void main(String[] args) {
    ListBaseQueue<Integer> queue = new ListBaseQueue<>();

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
