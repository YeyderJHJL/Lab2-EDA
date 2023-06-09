package Ejercicio4;

public class Node<T> {
  
  private T data;
  private Node<T> nextNode;

  public Node(){
  }
  
  public Node(T data, Node<T> nextNode){
    this.data = data;
    this.nextNode = nextNode;
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

  public boolean equals(Node<T> node){
    if(this == node){
      return true;
    }
    if(!(node instanceof Node)){
      return false;
    }
    return this.data.equals(node.getData()) && this.nextNode.equals(node.getNextNode());
  }
}

