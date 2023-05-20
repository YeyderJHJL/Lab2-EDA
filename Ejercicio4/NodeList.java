package Ejercicio4;

public class NodeList<T> {
  Node<T> root;

  public void add(T element) {
    Node<T> newNode = new Node<>();
    newNode.setData(element);

    if (this.root == null) {
      this.root = newNode;
    } else {
      Node<T> currentNode = root;

      while (currentNode.nextNode != null) {
        currentNode = currentNode.nextNode;
      }

      currentNode.nextNode = newNode;
    }
  }
}
