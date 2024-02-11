package data.structrue.heap;

import java.util.Comparator;

public class UsefulHeapMain {
  public static void main(String[] args) {
    Comparator<String> comp = (o1, o2) -> {
      //내림차순
      return (o1.compareToIgnoreCase(o2));
    };
    String[] arr = new String[100];
    UsefulHeap<String> heap = new UsefulHeap<>(comp,arr);

    heap.insert("A");
    heap.insert("B");
    heap.insert("C");

    String delete = heap.delete();
    System.out.println(delete);

    heap.insert("A");
    heap.insert("B");
    heap.insert("C");

    delete = heap.delete();
    System.out.println(delete);

    while(!heap.isEmpty()){
      System.out.println(heap.delete());
    }
  }


}
