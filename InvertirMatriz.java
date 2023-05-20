public class InvertirMatriz {
  public static void main(String[] args) {
    int[] matrizPrueba = { 4, 3, 6, 0 };

    imprimirMatriz(matrizPrueba);
    imprimirMatriz(invertirMatriz(matrizPrueba));
  }

  public static int[] invertirMatriz(int[] matriz) {
    int[] matrizInvertida = new int[matriz.length];

    for (int i = 0; i < matriz.length; i++) {
      matrizInvertida[matriz.length - 1 - i] = matriz[i];
    }

    return matrizInvertida;
  }

  public static void imprimirMatriz(int[] matriz) {
    for (int i = 0; i < matriz.length; i++) {
      System.out.print(matriz[i] + " ");
    }

    System.out.println();
  }
}