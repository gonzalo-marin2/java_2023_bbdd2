package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import service.EmpleadosService;

public class TablaEmpleadosModel extends AbstractTableModel {
	List<Empleado> empleados;
	final int COLS=4;
	
	public TablaEmpleadosModel(String dep) {
		empleados=new EmpleadosService().empleadosPorDepartamento(dep);//para mostrar los empleados por departamento
	}

	@Override
	public int getRowCount() {
		return empleados.size();
	}

	@Override
	public int getColumnCount() {
		return COLS;
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "Id Empleado";
		case 1:
			return "Nombre";
		case 2:
			return "Email";
		case 3:
			return "Salario";
		default:
			return "Indeterminada";
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		case 0:
			return empleados.get(row).getIdEmpleado();
		case 1:
			return empleados.get(row).getNombre();
		case 2:
			return empleados.get(row).getEmail();
		case 3:
			return empleados.get(row).getSalario();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return int.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return Double.class;
		default:
			return null;
		}
	}
}
