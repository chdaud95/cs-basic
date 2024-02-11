package data.structrue.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class BinaryTree<T> {

  BinaryTreeNode<T> makeBTreeNode(){
    BinaryTreeNode<T> bNode = new BinaryTreeNode<>();
    bNode.left = null;
    bNode.right = null;
    return bNode;
  }
  public T getData(BinaryTreeNode<T> bt) {
    return bt.getData();
  }

  public void setData(BinaryTreeNode<T> bt,T data) {
    bt.setData(data);
  }

  BinaryTreeNode<T> getLeftSubTree(BinaryTreeNode<T> bt){
    return bt.getLeft();
  }

  BinaryTreeNode<T> getRightSubTree(BinaryTreeNode<T> bt){
    return bt.getRight();
  }

  void makeLeftSubTree(BinaryTreeNode<T> main,BinaryTreeNode<T> sub){
    if(main.getLeft() != null) {
      deleteTree(main.getLeft());
      main.setLeft(null);
    }
    main.setLeft(sub);
  }

  void makeRightSubTree(BinaryTreeNode<T> main,BinaryTreeNode<T> sub){
    if(main.getRight() != null) {
      deleteTree(main.getRight());
      main.setRight(null);
    }
    main.setRight(sub);
  }

  void deleteTree(BinaryTreeNode<T> bt){
    if(bt == null) return;

    deleteTree(bt.getLeft());
    deleteTree(bt.getRight());
    log.info("del tree data : {}",bt.getData());
    bt = null;
  }

  void preorderTraverse(BinaryTreeNode<T> bt, Consumer<T> action){
      if(bt == null) return;

      action.accept(bt.getData());
      preorderTraverse(bt.getLeft(),action);
      preorderTraverse(bt.getRight(),action);
  }

  void inorderTraverse(BinaryTreeNode<T> bt , Consumer<T> action){
    if(bt == null) return;

    inorderTraverse(bt.getLeft(),action);
    action.accept(bt.getData());
    inorderTraverse(bt.getRight(),action);
  }

  void postorderTraverse(BinaryTreeNode<T> bt , Consumer<T> action){
    if(bt == null) return;

    postorderTraverse(bt.getLeft(),action);
    postorderTraverse(bt.getRight(),action);
    action.accept(bt.getData());
  }
}
