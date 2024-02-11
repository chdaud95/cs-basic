package data.structrue.heap;

public class SimpleHeapMain {

  public static void main(String[] args) {
    HeapElem<String>[] heapArr = new HeapElem[100];
    SimpleHeap<String> heap = new SimpleHeap<>(heapArr);

    Priority pr1 = new Priority(1);
    Priority pr2 = new Priority(2);
    Priority pr3 = new Priority(3);

    heap.insert("A",pr1);
    heap.insert("B",pr2);
    heap.insert("C",pr3);


    String delete = heap.delete();
    System.out.println(delete);

    heap.preorderTraverse(1);

    heap.insert("A",pr1);
    heap.insert("B",pr2);
    heap.insert("C",pr3);

    delete = heap.delete();
    System.out.println(delete);

    while(!heap.isEmpty()){
      System.out.println(heap.delete());
    }
  }
}
