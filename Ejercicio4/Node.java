package Ejercicio4;

public class Node<T> {
  
  private T data;
  private Node<T> nextNode;

  public Node(){
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node<T> nextNode) {
    this.nextNode = nextNode;
  }
}

