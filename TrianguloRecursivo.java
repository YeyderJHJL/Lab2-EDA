public class TrianguloRecursivo{
    public static void main(String[] args) {
        trianguloRecursivo(5);
    }
    public static void trianguloRecursivo(int base){
        for(int i = 0; i < base; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}