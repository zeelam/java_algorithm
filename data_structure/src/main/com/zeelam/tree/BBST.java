package com.zeelam.tree;

import java.util.Comparator;

public class BBST<T> extends BinarySearchTree<T> {

  public BBST() {
    this(null);
  }

  public BBST(Comparator<T> comparator) {
    super(comparator);
  }

  protected void rotateLeft(Node<T> grand) {
    Node<T> parent = grand.right;
    Node<T> child = parent.left;
    grand.right = child;
    parent.left = grand;

    afterRotate(grand, parent, child);
  }

  protected void rotateRight(Node<T> grand) {
    Node<T> parent = grand.left;
    Node<T> child = parent.right;
    grand.left = child;
    parent.right = grand;

    afterRotate(grand, parent, child);
  }

  protected void afterRotate(Node<T> grand, Node<T> parent, Node<T> child) {
    // set parents
    if (child != null) {
      child.parent = grand;
    }
    parent.parent = grand.parent;
    if (grand.isLeftChild()) {
      grand.parent.left = parent;
    } else if (grand.isRightChild()){
      grand.parent.right = parent;
    } else {
      root = parent;
    }
    grand.parent = parent;
  }

  protected void unifyRotate(Node<T> r,
      Node<T> a, Node<T> b, Node<T> c,
      Node<T> d,
      Node<T> e, Node<T> f, Node<T> g) {
    // set root node
    d.parent = r.parent;
    if (r.isLeftChild()) {
      r.parent.left = d;
    } else if (r.isRightChild()) {
      r.parent.right = d;
    } else {
      root = d;
    }

    // set left tree
    b.left = a;
    if (a != null) {
      a.parent = b;
    }
    b.right = c;
    if (c != null) {
      c.parent = b;
    }

    // set right tree
    f.left = e;
    if (e != null) {
      e.parent = f;
    }
    f.right = g;
    if (g != null) {
      g.parent = f;
    }

    d.left = b;
    b.parent = d;
    d.right = f;
    f.parent = d;

  }

}
