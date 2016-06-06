package Iniciar;

import Controlador.Controlador;
import Modelo.BaseDatos;
import Vista.Mantenimiento;
import Vista.Principal;

public class Inicio {

	public static void main(String[] args) {
		Principal ppal = new Principal();
		BaseDatos bd = new BaseDatos ();
		Controlador ctrl = new Controlador();
		Mantenimiento mant = new Mantenimiento();
		
		
		ppal.setMenuManagement(mant);
		mant.setPrinc(ppal);
		mant.setCtrl(ctrl);
		mant.setBd(bd);
		ctrl.setDb(bd);
		bd.setMateriales(mant);
		
		ppal.setVisible(true);
	}

}
