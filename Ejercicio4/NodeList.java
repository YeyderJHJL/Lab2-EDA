package Ejercicio4;

import java.util.Collection;

public class NodeList<T> {
  
  private int size;
  private Node<T> root;

  public NodeList(){
    root = null;
    size = 0;
  }

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
    this.size++;
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
    this.size++;
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
    return listSize;}

  

  

  public void setSize(int size){
    this.size = size;
  }
  
  public void setRoot(Node<T> root){
    this.root = root;
  }
  
  public int getSize(){
    return this.size;
  }
  
  public Node<T> getRoot(){
    return this.root;
  }
  
  public boolean contains(T data){
    Node<T> myNode = this.root;
    while(myNode != null){
      if(myNode.getData().equals(data)){
        return true;
      }
      myNode = myNode.getNextNode();
    }
    return false;
  }
  
  public boolean containsAll(Node<T> datas){
    while (datas != null) {
      if (!contains(datas.getData())) {
        return false;
      }
      datas = datas.getNextNode();
    }
    return true;
  }
  
  public boolean equals(NodeList<T> datas){
    if (this == datas) {
      return true;
    }
    if (!(datas instanceof NodeList)) {
      return false;
    }
    NodeList<T> otherList = datas;
    if (this.getSize() != otherList.getSize()) {
      return false;
    }
    for (int i = 0; i < this.size; i++) {
      Node<T> element1 = this.getRoot();
      Node<T> element2 = otherList.getRoot();
      if (!element1.equals(element2)) {
        return false;
      }
    }
    return true;
  }

  public T get(int index){
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("Numero ingresado: "+index+", Tamaño de List: "+size);
    }
    Node<T> myNode = this.root;
    for (int i = 0; i < index; i++) {
      myNode = myNode.getNextNode();
    }
    return myNode.getData();
  }
  
  public int indexOf(T data){
    Node<T> myNode = this.root;
    for (int i = 0; i < this.size; i++) {
      if (data == null) {
        if (myNode.getData() == null) {
          return i;
        }
      } else {
        if (data.equals(myNode.getData())) {
          return i;
        }
      }
      myNode = myNode.getNextNode();
    }
    return -1;
  }

  public int lastindexOf(T data){
    Node<T> myNode = root;
    int lastIndex = -1;
    for (int i = 0; i < size; i++) {
      if (data == null) {
        if (myNode.getData() == null) {
          lastIndex = i;
        }
      } else {
        if (data.equals(myNode.getData())) {
          lastIndex = i;
        }
      }
      myNode = myNode.getNextNode();
    }
    return lastIndex;
  }

  public boolean isEmpty(){
    return size == 0;
  }


public String toString(){
  //Dentro de un string guardara toda la lista
  
  String listaCompleta = "";
  Node<T> actual = root;

  boolean nodo0= true;

  while(actual != null ){
    //El primer nodo empezara imprimiendo, a partir de este se separa de un guion
    if(nodo0){
      listaCompleta += actual.getData();
    }else{
      listaCompleta += " - " + actual.getData();
    }
    //cuando llegue a la ultima posicion sera null
    actual = actual.getNextNode();

  }
  return listaCompleta;
}
  

 //fue conveniente que se cree una lista local para algunos metodos
 private List<T> lista;

    // Constructor de la clase
    public NodeList(List<T> lista) {
        this.lista = lista;
    }
 
 

//Este metodo reemplaza el elemento en la posición especificada en esta lista con el elemento especificado.
   public T set(int index, T element) {    //como parametros recibe el indice de posicion y el elemento
	//si el indice esta fuera del rango
	if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("El índice se encuentra fuera de rango");
        }
        try {
	   T previousElement = (T) lista[index]; //lista es el nombre del arreglo
           lista[index] = element;
         return previousElement;
	}
	//si la operación de agregar no es compatible con esta lista
         catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("La operación no es compatible con esta lista");
	}
	//si la clase del elemento especificado impide que se agregue a esta lista
	 catch (ClassCastException e) {
            throw new ClassCastException("La clase del elemento especificado impide que se agregue a la lista");
        }
	//si el elemento especificado es nulo y esta lista no permite elementos nulos
	catch (NullPointerException e) {
            throw new NullPointerException("El elemento especificado es nulo y esta lista no permite elementos nulos");
        }
	//si alguna propiedad del elemento especificado impide que se agregue a esta lista
	catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Algún propiedad del elemento especificado impide que se agregue a esta lista");
        }
   }

//Este metodo devuelve el número de elementos de esta lista.(debe mejorarse)
   public static <T> int size() {
	if (isLargeList()) {
        return Integer.MAX_VALUE;
    } else {
	   return lista.size();  // Utiliza el método size() de la clase List para obtener el tamaño.
       }
    }

//Este metodo devuelve una vista de la parte de esta lista entre fromIndex , inclusive, y toIndex , exclusivo. 
  public List<T> sublist(int fromIndex, int toIndex) {
        // verifica si los indices son validos. 
	if (fromIndex < 0 || toIndex > lista.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Índices de sublista no son validos");
        }
        // crear una nueva lista para almacenar la sublista
        List<T> subList = new ArrayList<>();
	// oterar sobre los elementos desde fromIndex hasta toIndex y los agrega a la sublista
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(lista.get(i));
        }
        // devuelve la sublista creada
        return subList;
    }
//Este metodo elimina el elemento en la posición especificada en esta lista (puede mejorarse)
  public E remove(int index) {   //recibe como parametro el index
	//si el índice está fuera de rango 
        if (index < 0 || index >= lista.size()) {
            throw new IndexOutOfBoundsException("Indice fuera del rango");
        }
        T removedElement = lista[index];
        // Desplaza elementos subsiguientes a la izquierda
        for (int i = index; i < size - 1; i++) {
           lista[i] = lista[i + 1];
         }
        lista[size - 1] = null;  // elimina la referencia al último elemento
        size--;  // actualizar el tamaño de la lista
        return removedElement;  
  }
//Este metodo elimina la primera aparición del elemento especificado de esta lista, si está presente (operación opcional). Si esta lista no contiene el elemento, no se modifica. Más formalmente, elimina el elemento con el índice más bajo i tal que (o==null ? get(i)==null : o.equals(get(i))) (si tal elemento existe). Devuelve verdadero si esta lista contenía el elemento especificado (o de manera equivalente, si esta lista cambió como resultado de la llamada). 
public boolean remove(Object o) {
    // verifica si la operación de eliminación es compatible con esta lista
    if (!supportsRemoval()) {
        throw new UnsupportedOperationException("Operación de eliminación no es compatible con esta lista.");
    }
    // verifica si el objeto es nulo y la lista no permite elementos nulos
    if (o == null && !allowsNullElements()) {
        throw new NullPointerException("Esta lista no permite elementos nulos.");
    }
    // verifica si el objeto es compatible con los elementos de la lista
    if (o != null && !isElementTypeValid(o)) {
        throw new ClassCastException("El tipo de elemento es incompatible con esta lista.");
    }
    // busca el índice del elemento en la lista
    int index = -1;
    for (int i = 0; i < size(); i++) {
        if ((o == null && get(i) == null) || (o != null && o.equals(get(i)))) {
            index = i;
            break;
        }
    }
    // elimina el elemento si se encontró
    if (index != -1) {
        lista.remove(index);
        return true;
    } else {
        return false;
    }
}

//Este metodo Elimina de esta lista todos sus elementos que están contenidos en la colección especificada.
public boolean removeAll(Collection<?> c) {
    // verifica si la operación removeAll es compatible con esta lista
    if (!supportsRemoval()) {
        throw new UnsupportedOperationException("La operación removeAll no es compatible con esta lista.");
    }
    // verifica si la colección permite elementos nulos y esta lista contiene un elemento nulo
    if (!allowsNullElements() && c.contains(null) && contains(null)) {
        throw new NullPointerException("Esta lista contiene un elemento nulo y la colección especificada no permite elementos nulos.");
    }
    // verifica si la colección especificada tiene elementos incompatibles con esta lista
    for (Object element : c) {
        if (!isElementTypeValid(element)) {
            throw new ClassCastException("La clase de un elemento de la lista es incompatible con la colección especificada.");
        }
    }
    // elimina los elementos de la lista que están contenidos en la colección
    boolean modified = false;
    Iterator<?> iterator = iterator();
    while (iterator.hasNext()) {
        if (c.contains(iterator.next())) {
            iterator.remove();
            modified = true;
        }
    }
    return modified;
}

}

