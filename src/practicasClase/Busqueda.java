package practicasClase;

import java.util.Random;

public class Busqueda {

	public static void main(String[] args) {

		Random aleatorio = new Random();

		int[][] matriz1 = new int[4][3];
		System.out.println(matriz1.length);
		System.out.println(matriz1[0].length);
		// rellenamos matriz 1 con 1s

		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {

				matriz1[i][j] = aleatorio.nextInt(4);
			}
		}

		int[][] matriz2 = new int[3][3];

		// rellenamos matriz 2 con numeros

		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {
				matriz2[i][j] = aleatorio.nextInt(4);
			}
		}

		int[][] resultado = new int[4][3];

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {

				for (int k = 0; k < 2; k++) {
					resultado[i][j] = resultado[i][j] + matriz1[i][k] * matriz2[k][j];

				}

				System.out.print(resultado[i][j] + " ");

			}
			System.out.println();

			// temp tiene almacenado el valor correcto.

		}
	}

}
