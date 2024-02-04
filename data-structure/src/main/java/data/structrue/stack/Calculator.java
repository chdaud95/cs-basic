package data.structrue.stack;

public class Calculator {
  public static void main(String[] args) {
    String exp = "(1*2+3)/4";
    String postfix = postfix(exp);
    System.out.println(postfix);
    Long calculate = calculate(postfix);
    System.out.println(calculate);

  }

  public static Long calculate(String postfix){

    ListBaseStack<Long> stack = new ListBaseStack<>();

    for(int i = 0 ; i<postfix.length() ; i++){
      char a = postfix.charAt(i);
      if(isNumeric(a)) {
        stack.push(Long.parseLong(String.valueOf(a)));
        continue;
      }else{
        Long pop1 = stack.pop();
        Long pop2 = stack.pop();
        switch (a) {
          case '*' -> stack.push(pop2 * pop1);
          case '/' -> stack.push(pop2 / pop1);
          case '+' -> stack.push(pop2 + pop1);
          case '-' -> stack.push(pop2 - pop1);
        }
      }
    }

    return stack.pop();
  }

  public static String postfix(String exp){

    ListBaseStack<Character> stack = new ListBaseStack<>();
    StringBuilder sbf = new StringBuilder();

    for(int i = 0 ; i < exp.length() ; i++){
      char a = exp.charAt(i);
      if(isNumeric(a)){
        sbf.append(a);
        continue;
      }

      switch (a) {
        case '(' -> stack.push(a);
        case ')' -> {
          while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop.equals('(')) break;
            sbf.append(pop);
          }
        }
        case '+', '-', '*', '/' -> {
            while (!stack.isEmpty() && doPop(stack.peek(), a)) {
              Character pop = stack.pop();
              if (pop.equals('(') || pop.equals(')')) continue;
              sbf.append(pop);
            }
            stack.push(a);
        }
      }
    }

    while(!stack.isEmpty()){
      Character pop = stack.pop();
      if(pop.equals('(') ||pop.equals(')')) continue;
      sbf.append(pop);
    }


    return sbf.toString();
  }

  public static int getPriority(char a){
    return switch (a) {
      case '*', '/' -> 5;
      case '+', '-' -> 3;
      case '(' -> 1;
      default -> -1;
    };
  }

  public static boolean doPop(char a, char b){
    int priorityA = getPriority(a);
    int priorityB = getPriority(b);

    return priorityA >= priorityB; //스택에서 모두 뺀다
  }

  public static boolean isNumeric(char target) {
    try {
      Integer.parseInt(String.valueOf(target));
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }


}
