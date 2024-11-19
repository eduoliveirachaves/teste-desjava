import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;


public class Primos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long primo = 0;
        //validacao do input, verifica se e numero e tambem se e maior do que 1
        try {
            primo = Long.parseLong(scan.nextLine());
            if (primo < 2) {
                System.out.println("input invalido, numero deve ser maior que 1");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("input invalido, deve ser um numero");
            return;
        }
        System.out.println(primosLinearmente(primo));
        System.out.println(primosRecursivamente(primo, new ArrayList<>()));
    }

    static ArrayList<Long> primosLinearmente(long n) {
        ArrayList<Long> listaDePrimos = new ArrayList<>();
        for (long i = 2; i <= n; i++) {
            if (ehPrimo(i)) {
                listaDePrimos.add(i);
            }
        }
        return listaDePrimos;
    }

    static ArrayList<Long> primosRecursivamente(long n, ArrayList<Long> listaDePrimos) {
        if (n < 2) {
            sort(listaDePrimos);
            return listaDePrimos;
        }

        if (ehPrimo(n)) {
            listaDePrimos.add(n);
        }

        return primosRecursivamente(n - 1, listaDePrimos);
    }


    static boolean ehPrimo(long num) {
        //usa a raiz como condicao de parada
        double raizN = Math.sqrt(num);

        //otimiza em relacao aos num pares, assim o loop principal nao tem que verificar
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        for (int j = 3; j <= raizN; j += 2) {
            if (num % j == 0 && j != num) {
                return false;
            }
        }
        return true;
    }
}
