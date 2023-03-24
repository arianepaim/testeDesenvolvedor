package exerciciosEstagioTarget;

/*5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou
pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
*/

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite uma palavra: ");
		String normal = scan.nextLine();

		String invertida = "";

		for (int i = normal.length() - 1; i >= 0; i--) {
			invertida += normal.charAt(i);
		}

		System.out.println("Normal: " + normal);
		System.out.println("Invertida: " + invertida);
		
		scan.close();
	}

}
