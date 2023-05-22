import java.util.*;

public class TrianguloRecursivo{
    public static void main(String[] args) {
        Scanner jh = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de asteriscos de la base del triángulo: ");
        int base = jh.nextInt();
        trianguloRecursivo(base);
    }
    public static void trianguloRecursivo(int base){
        System.out.println("triangulo recursivo");
        for(int i = 0; i < base; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}