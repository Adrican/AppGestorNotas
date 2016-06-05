package Iniciar;

import Controlador.Controlador;
import Modelo.BaseDatos;
import Vista.Mantenimiento;

public class Inicio {

	public static void main(String[] args) {
		
		BaseDatos bd = new BaseDatos ();
		Controlador ctrl = new Controlador();
		Mantenimiento mant = new Mantenimiento();
		
		mant.setCtrl(ctrl);
		mant.setBd(bd);
		ctrl.setDb(bd);
		bd.setMateriales(mant);
		
		mant.setVisible(true);
	}

}
