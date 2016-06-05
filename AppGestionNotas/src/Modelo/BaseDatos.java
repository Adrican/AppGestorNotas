package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Vista.Mantenimiento;

public class BaseDatos {
	private Mantenimiento mant;
	private Connection conexion;
	private String bd, login, pwd, url;
	private String[][] tabla;
	private String[][] tabla2;
	public BaseDatos() {
		try {
			login = "ENTORNOS";
			pwd = "ENTORNOS";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String mi_url = "jdbc:oracle:thin:@localhost:1521:XE";
			conexion = DriverManager.getConnection(mi_url, "ENTORNOS", "ENTORNOS");
			System.out.println("-- Conexión establecida --");
		} catch (ClassNotFoundException e) {
			System.out.println("No tengo el driver cargado");
		} catch (SQLException e) {
			System.out.println("Falla la conexión");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void consultaMateriales() {
		try {
			String nfilas = "Select count(*) from PROFESORES";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);

			String query = "Select nom_profe , apellidos_profe , MODULO from profesores, MODULOS WHERE cod_profe = PROFESORES_COD_PROFE";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla = new String[f][c];
			while (rset.next()) {
				for (int j = 0; j < c; j++) {
				tabla[i][j] = rset.getString(j+1);
				}
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		mant.rellenarTabla();
	}
	
	public void consultaNotas() {
		try {
			String nfilas = "Select count(*) from notas";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);

			String query = "Select MODULOS_MODULO,NOM_ALUMNO, APELLIDOS_ALUMNO, NOTA from NOTAS, alumnos WHERE ALUMNOS_COD_ALUMNO = ALUMNOS_COD_ALUMNO";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla2 = new String[f][c];
			while (rset.next()) {
				for (int j = 0; j < c; j++) {
				tabla2[i][j] = rset.getString(j+1);
				}
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		mant.rellenarTabla2();
	}
	public String Consulta(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int columna = 1;// Variable de seleccion de columna en la tabla
			String anser = "";// respuesta de la select
			while (rset.next()) {
				anser = (anser + rset.getString(columna) + " ");
				columna++;
			}
			return anser;
		} catch (SQLException s) {
			s.printStackTrace();
			return "";
		}
	}

	public boolean NuevosDatos(String sql) {
		try {
			Statement stmt = conexion.createStatement();
			int rset = stmt.executeUpdate(sql);// si es correcto 1 y si catch
			if (rset == 1) {
				return true;
			}
			return false;
		} catch (SQLException s) {
			s.printStackTrace();
			return false;
		}
	}
	public String[][] getMateriales() {
		return tabla;
	}
	public String[][] getNotas() {
		return tabla2;
	}
	public boolean INSERT(String tabla, String columa, String dato) {
		return NuevosDatos("INSERT INTO " + tabla + "(" + columa + ") VALUES ('" + dato + "')");
	}
	public void setMateriales(Mantenimiento mant) {
		this.mant = mant;
	}
	
	public boolean selecCombo(String Tabla,String Columna){
		return NuevosDatos("SELECT "+Columna+" FROM " + Tabla);
		
	}
	

}
