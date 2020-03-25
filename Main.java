package EjerciciosRR;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Conector instancia = Conector.getInstancia();
		// Ejercicio 1
		System.out.println("Ejercicio 1");
		try {
			ArrayList<String> totalInvList = instancia.getTotalInv();
			for (String Ejercicio1 : totalInvList) {
				System.out.println(Ejercicio1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		
		// Ejecercio 2
		System.out.println("Ejercicio 2");

		try {
			ArrayList<String> nombreList = instancia.getNombre();
			for (String Ejercicio2 : nombreList) {
				System.out.println(Ejercicio2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
		// Ejecercio 3
		System.out.println("Ejercicio 3");
		try {
			ArrayList<String> nombreIngrList = instancia.getNombreIngr();
			for (String Ejercicio3 : nombreIngrList) {
				System.out.println(Ejercicio3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
