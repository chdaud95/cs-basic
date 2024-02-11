package data.structrue.tree;

import data.structrue.stack.ListBaseStack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpressionTree {

  BinaryTree<String> tree = new BinaryTree<>();
  BinaryTreeNode<String> makeExpTree(String exp){
    ListBaseStack<BinaryTreeNode<String>> stack = new ListBaseStack<>();

    int expLength = exp.length();
    int i;

    for(i = 0 ; i<expLength ; i++){
      BinaryTreeNode<String> bNode = tree.makeBTreeNode();
      if(isNumeric(exp.charAt(i))){
        bNode.setData(String.valueOf(exp.charAt(i)));
      }else{
        tree.makeRightSubTree(bNode,stack.pop());
        tree.makeLeftSubTree(bNode,stack.pop());
        bNode.setData(String.valueOf(exp.charAt(i)));
      }
      stack.push(bNode);
    }
    return stack.pop();
  }

  int evaluateExpTree(BinaryTreeNode<String> bt){

    if(tree.getLeftSubTree(bt) == null && tree.getRightSubTree(bt) == null) return Integer.parseInt(bt.getData());
    int op1 = evaluateExpTree(tree.getLeftSubTree(bt));
    int op2 = evaluateExpTree(tree.getRightSubTree(bt));

    switch (bt.getData()){
      case "+": return op1 + op2;
      case "-": return op1 - op2;
      case "*": return op1 * op2;
      case "/": return op1 / op2;
    }

    return 0;
  }

  void showPrefixTypeExp(BinaryTreeNode<String> bt){
    tree.preorderTraverse(bt, System.out::print);
  }


  void showInfixTypeExp(BinaryTreeNode<String> bt){

    if(bt == null) return;

    if(bt.getLeft() != null || bt.getRight() != null) System.out.print("(");
    showInfixTypeExp(bt.getLeft());
    System.out.print(bt.getData());
    showInfixTypeExp(bt.getRight());
    if(bt.getLeft() != null || bt.getRight() != null) System.out.print(")");

  }

  void showPostfixTypeExp(BinaryTreeNode<String> bt){
    tree.postorderTraverse(bt, System.out::print);
  }


  public boolean isNumeric(char target) {
    try {
      Integer.parseInt(String.valueOf(target));
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
