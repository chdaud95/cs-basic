package data.structrue.stack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayBaseStackMain {

  public static void main(String[] args) {
    ArrayBaseStack<Integer> stack = new ArrayBaseStack<>(new Integer[5]);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);


    while(!stack.isEmpty()){
      log.info("데이터 : {}",stack.pop());
    }

  }
}
