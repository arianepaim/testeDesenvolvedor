package exerciciosEstagioTarget;

/*3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça
um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média
mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
Estes dias devem ser ignorados no cálculo da média;
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Exercicio3 {

	public static void main(String[] args) {

		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("src/exerciciosEstagioTarget/dados.json"));
			JsonArray jsonArray = gson.fromJson(bufferedReader, JsonArray.class);

			ArrayList<Double> faturamentos = new ArrayList<Double>();

			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				faturamentos.add(jsonObject.get("valor").getAsDouble());
			}

			double menorFaturamento = Double.MAX_VALUE;
			double maiorFaturamento = faturamentos.get(0);
			double somaFaturamentos = 0;
			int diasAcimaDaMedia = 0;
			for (Double faturamento : faturamentos) {
				if (faturamento > 0) {
					somaFaturamentos += faturamento;
					if (faturamento < menorFaturamento) {
						menorFaturamento = faturamento;
					}
					if (faturamento > maiorFaturamento) {
						maiorFaturamento = faturamento;
					}
				}
			}
			double mediaMensal = somaFaturamentos / faturamentos.size();
			for (Double faturamento : faturamentos) {
				if (faturamento > mediaMensal) {
					diasAcimaDaMedia++;
				}
			}
			System.out.println("Menor faturamento: " + menorFaturamento);
			System.out.println("Maior faturamento: " + maiorFaturamento);
			System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}