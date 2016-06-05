package Controlador;
import Modelo.BaseDatos;

public class Controlador {
	private BaseDatos db;
	
	public void setDb(BaseDatos db) {
		this.db = db;
	}

	public void cargarMateriales(){
		db.consultaMateriales();
		
		
		 
	}
	public void cargarNotas(){
		db.consultaNotas();
	}
	public boolean Insert(String tabla,String columna,String dato){
		 return db.INSERT(tabla, columna, dato);
	 }
	 public boolean SELECT(String tabla,String columna){
		 return db.selecCombo(tabla, columna);
	 }
}
