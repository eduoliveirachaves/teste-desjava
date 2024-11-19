import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long fibo;
        //validacao do input, verifica se e numero e tambem se e maior do que 0
        try {
            fibo = Long.parseLong(scan.nextLine());
            if (fibo < 0) {
                System.out.println("input invalido, numero deve ser positivo");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("input invalido, entrada deve ser um numero");
            return;
        }
        System.out.println(fibonacciLinearmente(fibo));
        System.out.println(fibonacciRecursivamente(fibo));
    }

    static long fibonacciLinearmente(long n) {
        //0 , 1 , 1, 2, 3, 5, 8, 13, 21
        long fibonacci = 0;
        long fiboAtual = 1;
        for (long i = 1; i < n; i++) {
            long fibo = fibonacci + fiboAtual;
            fibonacci = fiboAtual;
            fiboAtual = fibo;
        }
        return fiboAtual;
    }

    static long fibonacciRecursivamente(long n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursivamente(n - 1) + fibonacciRecursivamente(n - 2);
    }
}
