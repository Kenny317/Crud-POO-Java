package crudmvc;

import Controlador.CtrlProducto;
import Modelo.Consultas;
import Modelo.Producto;
import Vista.FormProducto;

public class Crudmvc {

		
	public static void main(String[] args) {
		
		Producto pro = new Producto();
		Consultas consul = new Consultas();
		FormProducto formP = new FormProducto();
		
		CtrlProducto ctrl = new CtrlProducto(pro, consul, formP);
		ctrl.Iniciar();
		formP.setVisible(true);
	}
}
