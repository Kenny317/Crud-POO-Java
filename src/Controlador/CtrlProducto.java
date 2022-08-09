package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Consultas;
import Modelo.Producto;
import Vista.FormProducto;

public class CtrlProducto implements ActionListener{

	private Producto modP;
	private Consultas modC;
	private FormProducto formP;
	
	public CtrlProducto (Producto modP, Consultas modC, FormProducto formP)
	{
		this.modP = modP;
		this.modC = modC;
		this.formP = formP;
		this.formP.btnGuardar.addActionListener(this);
		this.formP.btnModificar.addActionListener(this);
		this.formP.btnEliminar.addActionListener(this);
		this.formP.btnLimpiar.addActionListener(this);
		this.formP.btnBuscar.addActionListener(this);
	}

	public void Iniciar() {
		formP.setTitle("Productos");
		formP.setLocationRelativeTo(null);
		formP.txtId.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == formP.btnGuardar) {
			modP.setCodigo(formP.txtCodigo.getText());
			modP.setNombre(formP.txtNombre.getText());
			modP.setPrecio(Double.parseDouble(formP.txtPrecio.getText()));
			modP.setCantidad(Integer.parseInt(formP.txtCantidad.getText()));
			
			if(modC.Registrar(modP)) {
				JOptionPane.showMessageDialog(null,"Registro guardado");
				Limpiar();
			}else {
				JOptionPane.showMessageDialog(null,"Error al guardar");
				Limpiar();
			}
		}
		
		if(e.getSource() == formP.btnModificar) {
			modP.setId(Integer.parseInt(formP.txtId.getText()));
			modP.setCodigo(formP.txtCodigo.getText());
			modP.setNombre(formP.txtNombre.getText());
			modP.setPrecio(Double.parseDouble(formP.txtPrecio.getText()));
			modP.setCantidad(Integer.parseInt(formP.txtCantidad.getText()));
			
			if(modC.Modificar(modP)) {
				JOptionPane.showMessageDialog(null,"Registro modificado");
				Limpiar();
			}else {
				JOptionPane.showMessageDialog(null,"Error al modificar");
				Limpiar();
			}
		}
		
		if(e.getSource() == formP.btnEliminar) {
			modP.setId(Integer.parseInt(formP.txtId.getText()));
			
			if(modC.Eliminar(modP)) {
				JOptionPane.showMessageDialog(null,"Registro eliminado");
				Limpiar();
			}else {
				JOptionPane.showMessageDialog(null,"Error al eliminar");
				Limpiar();
			}
		}
		
		if(e.getSource() == formP.btnBuscar) {
			modP.setCodigo(formP.txtCodigo.getText());
			
			if(modC.Buscar(modP)) {
				formP.txtId.setText(String.valueOf(modP.getId()));
				formP.txtCodigo.setText(modP.getCodigo());
				formP.txtNombre.setText(modP.getNombre());
				formP.txtPrecio.setText(String.valueOf(modP.getPrecio()));
				formP.txtCantidad.setText(String.valueOf(modP.getCantidad()));
			}else {
				JOptionPane.showMessageDialog(null,"No se encontro registro");
				Limpiar();
			}
		}
		
		if(e.getSource() == formP.btnLimpiar) {
			Limpiar();
		}
	}
	
	public void Limpiar() {
		formP.txtId.setText(null);
		formP.txtCodigo.setText(null);
		formP.txtNombre.setText(null);
		formP.txtPrecio.setText(null);
		formP.txtCantidad.setText(null);
	}
	
}
