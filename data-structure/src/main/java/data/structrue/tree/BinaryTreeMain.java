package data.structrue.tree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeMain {

  public static void main(String[] args) {
    BinaryTree<Integer> tree = new BinaryTree<>();

    BinaryTreeNode<Integer> bt1 = tree.makeBTreeNode();
    BinaryTreeNode<Integer> bt2 = tree.makeBTreeNode();
    BinaryTreeNode<Integer> bt3 = tree.makeBTreeNode();
    BinaryTreeNode<Integer> bt4 = tree.makeBTreeNode();
    BinaryTreeNode<Integer> bt4_left = tree.makeBTreeNode();
    BinaryTreeNode<Integer> bt4_right = tree.makeBTreeNode();

    BinaryTreeNode<Integer> bt5 = tree.makeBTreeNode();

    tree.setData(bt1,1);
    tree.setData(bt2,2);
    tree.setData(bt3,3);
    tree.setData(bt4,4);
    tree.setData(bt4_left,6);
    tree.setData(bt4_right,7);
    tree.setData(bt5,5);


    tree.makeLeftSubTree(bt1,bt2);
    tree.makeRightSubTree(bt1,bt3);
    tree.makeLeftSubTree(bt2,bt4);
    tree.makeLeftSubTree(bt4,bt4_left);
    tree.makeRightSubTree(bt4,bt4_right);

    tree.makeLeftSubTree(bt2,bt5);

//    tree.inorderTraverse(bt1,data -> {
//      log.info("data : {} ",data);
//    });
//    log.info("##################");
//    tree.preorderTraverse(bt1,data -> {
//      log.info("pre data : {} ",data);
//    });
//    log.info("##################");
//    tree.postorderTraverse(bt1,data -> {
//      log.info("post data : {} ",data);
//    });
  }


}

