package data.structrue.list;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedListMain {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();

//    list.setSortRule((a,b) -> {
//      int result = a.compareTo(b);
//      if( result > 0) return result;
//      else return 0;
//    });

    list.insert("c");
    list.insert("d");
    list.insert("a");
    list.insert("z");
    list.insert("u");

    String first = list.first();
    if(first != null){
      log.info("첫번째 값 : {}",first);
      String next;
      while((next = list.next()) != null){
        log.info("다음 값 : {}",next);
      }
    }



  }
}
