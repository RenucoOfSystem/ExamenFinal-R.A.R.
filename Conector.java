package EjerciciosRR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {

	// atributos

	private static Connection con;
	private static Conector INSTANCE = null;

	private Conector() {

	}

	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	public static Conector getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	// Conexion al usuario
	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "root";
		String password = "elrenuco";
		String dataBase = "restaurant";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://" + host + "/" + dataBase + "?" + "user=" + user + "&password="
					+ password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Lo lograste skere!");
			System.out.println();
		} catch (Exception e) {

		}

	}

	// Ejercicio 1
	public ArrayList<String> getTotalInv() throws SQLException {
		ArrayList<String> totalInvList = new ArrayList<String>();  // 
		PreparedStatement ps = con
				.prepareStatement("select sum(inventory)" + " from ingredients "
						+ " where unit = 'bowl'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			totalInvList.add(rs.getString("TotalInv") );
		}
		rs.close();
		return totalInvList;
	}

	
	
	
	// Ejecercio 2
	public ArrayList<String> getNombre() throws SQLException {
		ArrayList<String> nombreList = new ArrayList<String>(); // 
		PreparedStatement ps = con
				.prepareStatement("select items.name "+ " from madewith" 
		+ " inner join items on madewith.itemid = items.itemid "
		+ "inner join ingredients on madewith.ingredientid = ingredients.ingredientid && ingredients.unitprice = (select max(unitprice) from ingredients);");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nombreList.add(rs.getString("Nombre"));
		}
		rs.close();
		return nombreList;
	}

	// Ejecercio 3
	public ArrayList<String> getNombreIngr() throws SQLException {
		ArrayList<String> nombreIngrList = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select name "
				+ " from ingredients " + "inner join vendors on ingredients.vendorid = vendors.vendorid && vendors.repfname like '%y'"
				+ "  order by name asc");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nombreIngrList.add(rs.getString("Nombre ingredientes: "));
		}
		rs.close();
		return nombreIngrList;
	}

}
