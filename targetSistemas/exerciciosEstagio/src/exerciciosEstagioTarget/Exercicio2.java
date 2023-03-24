package exerciciosEstagioTarget;

/*2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre
será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
escreva um programa na linguagem que desejar onde, informado um número, ele calcule a
sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence
ou não a sequência.

IMPORTANTE:
Esse número pode ser informado através de qualquer entrada de sua preferência ou pode
ser previamente definido no código;
*/

import java.util.Scanner;

public class Exercicio2 {
	
	public static void main(String[] args) {
        int numero;
        int a = 0;
        int b = 1;
        int troca;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        numero = scan.nextInt();
        
        while (b < numero) {
            troca = b;
            b = a + b;
            a = troca;
        }
        
        if (b == numero) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
        
        scan.close();
    }

}
