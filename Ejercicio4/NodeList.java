package Ejercicio4;

import java.util.Collection;

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

  public void add(int index, T element) {
    // Se verifica si el elemento añadir estara dentro de rango
    if (index <= this.size()) {
      // Se verifica que la lista no este vacia
      if (this.root != null) {
        // Se crea un nuevo Nodo y se le agrega su elemento
        Node<T> newNode = new Node<>();
        newNode.setData(element);
        // Se crea la variable currentNode y se le asigna el valor de la raiz
        Node<T> currentNode = this.root;

        // Se avanca por los nodos hasta llegar al nodo anterior al nodo que queremos
        // agregar
        for (int i = 1; i < index; i++) {
          currentNode = currentNode.getNextNode();
        }

        // Se verifica que el currentNode no sea el ultimo de la lista
        if (currentNode.getNextNode() != null) {
          // El siguiente nodo del currentNode pasa a ser el siguiente nodo del nuevo nodo
          newNode.setNextNode(currentNode.getNextNode());
        }
        // Se asigna el nuevo nodo como el siguiente del currentNode
        currentNode.setNextNode(newNode);
      } else {
        // Si la lista esta vacia se usa el metodo add(element) para añadir el nuevo
        // elemento
        this.add(element);
      }
    } else {
      // Al no estar dentro del rango se mandara un mensaje
      System.out.println("No se puede añadir un elemento fuera de rango");
    }
  }

  public void addAll(Collection<? extends T> c) {
    // Va agregando elemento por elemento a la lista
    for (T element : c) {
      this.add(element);
    }
  }

  public void addAll(int index, Collection<? extends T> c) {
    // va agregando elemento por elemento a la lista, pero agrega un elemento en el
    // index posterior al elemento anteriormente agregado
    for (T element : c) {
      this.add(index, element);
      index++;
    }
  }

  public void clear() {
    // Elimina la referencia a la raiz, eliminando todos los nodos en consecuencia
    this.root = null;
  }

  // Este metodo aun no esta hecho, pero deberia devolver el tamaño de la lista
  public int size() {
    int listSize = 0;
    return listSize;
  }
}
