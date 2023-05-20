import java.util.*;

class RotacionIzquierda {

    public static void main(String[] args) {

    int[] arrayPrueba = {1, 2, 3, 4, 5};
    int[] arrayRotado = rotar(arrayPrueba);
    }

    public static int[] rotar(int[] A){
       Scanner scan = new Scanner(System.in);
       System.out.print("\nIngrese la cantidad de valores que desea rotar a la izquierda(1-5): ");

       int d = scan.nextInt();
       int[] Aiz = new int[A.length];

       for (int i = 0; i < A.length; i++)   {
        int newIndex = (i + d) % A.length;
        Aiz[i] = A[newIndex];               }

       return Aiz;
    }

}

