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
	   T previousElement = (T) list[index]; //list es el nombre del arreglo
           list[index] = element;
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


}

