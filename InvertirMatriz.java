public class InvertirMatriz {
  public static void main(String[] args) {
    int[] matrizPrueba = {4, 3, 6, 0};
    
    imprimirMatriz(matrizPrueba);
  }

  public static void imprimirMatriz(int[] matriz) {
    for(int i = 0; i < matriz.length; i++) {
      System.out.print(matriz[i] + " ");
    }
  }
}