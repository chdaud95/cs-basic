package data.structrue.list;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CircularLinkedListMain {
  public static void main(String[] args) {
    CircularLinkedList<Integer> list = new CircularLinkedList<>();
    list.insert(3);
    list.insert(4);
    list.insert(5);
    list.frontInsert(2);
    list.frontInsert(1);

//    list.allPrint();

    Integer first = list.first();
    if(first != null){
      System.out.print(first);
      Integer next;
      for(int i = 0 ; i< list.count()*3 -1 ; i++){
        if((next = list.next()) != null){
          System.out.print(next);
        }
      }
    }

    System.out.println("");
    first = list.first();
    if(first != null){
      if(first%2 == 0){
        list.remove();
      }
      Integer next;
      for(int i = 0 ; i< list.count() -1 ; i++){
        if((next = list.next()) != null){
          if(next%2 == 0){
            list.remove();
          }
        }
      }
    }
//    list.allPrint();

    System.out.println("");
    first = list.first();
    if(first != null){
      System.out.print(first);
      Integer next;
      for(int i = 0 ; i< list.count() -1 ; i++){
        if((next = list.next()) != null){
          System.out.print(next);
        }
      }
    }

  }
}
