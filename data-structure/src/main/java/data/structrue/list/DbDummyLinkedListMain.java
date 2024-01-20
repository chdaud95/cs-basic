package data.structrue.list;

public class DbDummyLinkedListMain {

  public static void main(String[] args) {
    DbDummyLinkedList<Integer> list = new DbDummyLinkedList<>();
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.insert(6);
    list.insert(7);
    list.insert(8);

    Integer first = list.first();
    if(first != null){
      System.out.print(first);
      Integer next;
      while((next = list.next()) != null ){
        System.out.print(next);
      }
      System.out.println("");
    }

    first = list.first();
    if(first != null){
      if(first % 2 == 0){
        list.remove();
      }
      Integer next;
      while((next = list.next()) != null ){
        if(next % 2 == 0){
          list.remove();
        }
      }
    }

    first = list.first();
    if(first != null){
      System.out.print(first);
      Integer next;
      while((next = list.next()) != null ){
        System.out.print(next);
      }
      System.out.println("");
    }
  }

}
