import java.util.*;

class RotacionIzquierda {

    public static void main(String[] args) {

    int[] arrayPrueba = {1, 2, 3, 4, 5};
      System.out.println("Array: ");
      imprimir(arrayPrueba);
    int[] arrayRotado = rotar(arrayPrueba);
      System.out.println("\nArray rotado a la izquierda: ");
      imprimir(arrayRotado);

    }

    public static int[] rotar(int[] A){
       Scanner scan = new Scanner(System.in);
       System.out.print("\nIngrese la cantidad de valores que desea rotar a la izquierda: ");

       int d = scan.nextInt();
       int[] Aiz = new int[A.length];

       for (int i = 0; i < A.length; i++)   {
        int newIndex = (i + d) % A.length;
        Aiz[i] = A[newIndex];               }

       return Aiz;
    }

    public static void imprimir(int[] A) {
        for (int i=0; i<A.length; i++)      {
            System.out.print(A[i] + " ");   }
    }

}

