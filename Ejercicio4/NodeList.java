package Ejercicio4;

public class NodeList<T> {
  Node<T> root;

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
	   private List<T> lista; //lista es el nombre del arreglo.
        return lista.size();  // Utiliza el método size() de la clase List para obtener el tamaño.

    }

//Este metodo devuelve una vista de la parte de esta lista entre fromIndex , inclusive, y toIndex , exclusivo. 
  public List<T> sublist(int fromIndex, int toIndex) {
        // verifica si los indices son validos. 
	if (fromIndex < 0 || toIndex > lista.size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Índices de sublista no son validos");
        }
        // Crear una nueva lista para almacenar la sublista
        List<T> subList = new ArrayList<>();
	// Iterar sobre los elementos desde fromIndex hasta toIndex y los agrega a la sublista
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elements.get(i));
        }
        // Devuelve la sublista creada
        return subList;
    }
}

