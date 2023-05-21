package Ejercicio4;

public class NodeList<T> {
  Node<T> root;
/*
 considero conveniente que se crea una lista local para algunos metodos
 private List<T> lista;

    // Constructor de la clase
    public NodeList(List<T> lista) {
        this.lista = lista;
    }
 
 */

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

//Este metodo devuelve el número de elementos de esta lista.
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
//Este metodo elimina el elemento en la posición especificada en esta lista
  public void remove(int index) {   //recibe como parametro el index
	//si el índice está fuera de rango 
        if (index < 0 || index >= lista.size()) {
            throw new IndexOutOfBoundsException("Indice fuera del rango");
        }
        // obtener el elemento en la posición especificada
        T removedElement = lista.get(index);
        // eliminar el elemento de la lista
        elements.lista(index);
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

