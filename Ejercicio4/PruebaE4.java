package Ejercicio4;

public class PruebaE4 {
  public static void main(String[] args) {
      NodeList<String> listaAnimal = new NodeList<>();

      listaAnimal.add("PERRO");
      listaAnimal.add("GATO");
      listaAnimal.add("ELEFANTE");
      listaAnimal.add("CANGURO");
      listaAnimal.add("SERPIENTE");
      listaAnimal.add("RATON");

      System.out.println("CREANDO LISTA ANIMAL...");

      System.out.println("La lista está vacia"+listaAnimal.isEmpty());
      System.out.println("Tamaño actual de lista: "+ listaAnimal.getSize());
      
      System.out.println("Contiene la palabra 'CANGURO'? "+listaAnimal.contains("CANGURO"));

      System.out.println("Elementos de la lista: "+listaAnimal.toString());
      System.out.println("Tamaño actual: "+listaAnimal.getSize());

      System.out.println("Añadir elemento MONO ");
      listaAnimal.add("MONO");
      System.out.println("Añadir elemento Araña ");
      listaAnimal.add(2,ARAÑA);

    }
}
