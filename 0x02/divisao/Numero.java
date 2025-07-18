public class Numero {
    public static void dividir(int a, int b) {
        int resultado = 0;
        boolean erro = false;
        try {
            resultado = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Nao eh possivel dividir por zero");
            erro = true;
        } finally {
            System.out.printf("%d / %d = %d\n", a, b, resultado);
        }
    }
}