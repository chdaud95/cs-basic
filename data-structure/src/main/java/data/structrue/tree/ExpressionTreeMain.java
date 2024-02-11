package data.structrue.tree;

import data.structrue.stack.ListBaseStack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpressionTreeMain {

  public static void main(String[] args) {
    ExpressionTree expTree = new ExpressionTree();
    String exp = "12+7*";
    BinaryTreeNode<String> bNode = expTree.makeExpTree(exp);

    expTree.showPrefixTypeExp(bNode);
    System.out.println();
    expTree.showInfixTypeExp(bNode);
    System.out.println();
    expTree.showPostfixTypeExp(bNode);
    System.out.println();

    int result = expTree.evaluateExpTree(bNode);
    System.out.println(result);


  }

}
