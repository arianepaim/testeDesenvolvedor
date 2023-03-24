package exerciciosEstagioTarget;

/*4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de
representação que cada estado teve dentro do valor total mensal da distribuidora.
*/

import java.util.HashMap;
import java.util.Map;

public class Exercicio4 {

	public static void main(String[] args) {

		Map<String, Double> faturamentoPorEstado = new HashMap<>();
		faturamentoPorEstado.put("SP", 67836.43);
		faturamentoPorEstado.put("RJ", 36678.66);
		faturamentoPorEstado.put("MG", 29229.88);
		faturamentoPorEstado.put("ES", 27165.48);
		faturamentoPorEstado.put("Outros", 19849.53);

		double totalFaturamento = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

		for (String estado : faturamentoPorEstado.keySet()) {
			double percentual = faturamentoPorEstado.get(estado) / totalFaturamento * 100;
			System.out.printf("%s: %.2f%%\n", estado, percentual);
		}
	}

}
