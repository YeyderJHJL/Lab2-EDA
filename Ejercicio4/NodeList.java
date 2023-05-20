package Ejercicio4;

public class NodeList<T> {
  Node<T> root;

  public void add(T element) {
    // Se crea un nuevo nodo y se le asigna el valor del objeto introducido
    Node<T> newNode = new Node<>();
    newNode.setData(element);

    // Se revisa si la lista esta vacia
    if (this.root == null) {
      // Como esta vacia, el nodo creado se asigna como el nodo raiz
      this.root = newNode;
    } else {
      // Creamos la variable currentNode para recorrer la lista
      Node<T> currentNode = root;

      // Este while hace avanzar a currentNode hasta que este ya no tenga un siguiente
      // nodo lo que significa que este es el ultimo nodo de la lista
      while (currentNode.getNextNode() != null) {
        currentNode = currentNode.getNextNode();
      }

      // Estando en el ultimo nodo de la lista le asignamos el nuevo nodo como el nodo
      // que le sige. Asi posicionando el nuevo nodo como el nuevo ultimo
      currentNode.setNextNode(newNode);
    }
  }
}
