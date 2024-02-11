package data.structrue.tree;

import lombok.Data;

@Data
public class BinaryTreeNode<T> {
  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;
}
