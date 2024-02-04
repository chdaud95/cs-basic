package data.structrue.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class AdvanceCalculator {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<String> queue =  new LinkedList<>();
    String str;
    while((str = br.readLine()) != null){
      System.out.println(str);
      queue.add(str);
    }

//    String poll = queue.poll();
//    System.out.println(poll);
//    br.close();
  }


  public static int getPriority(char sign){
    return switch (sign) {
      case '*', '/' -> 5;
      case '+', '-' -> 3;
      case '(' -> 1;
      default -> -1;
    };
  }

  public static boolean doPop(char a , char b){
    int priorityA = getPriority(a);
    int priorityB = getPriority(b);

    return priorityA >= priorityB;
  }
}
