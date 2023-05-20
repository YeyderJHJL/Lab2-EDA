package Ejercicio4;

public class NodeList<T> {
  Node<T> root;


//Este metodo devuelve el elemento en la posición especificada en la lista.
   public T get(int index) { 		    //recibe el indice como parametro
        if (index < 0 || index >= size) {   //informa en caso el indice esta fuera del rango 
            System.out.print("El índice ingresado está fuera del rango");
        }
        return (T) elements[index];         //devuelve el elemento en la posicion especificada
    } 

}

