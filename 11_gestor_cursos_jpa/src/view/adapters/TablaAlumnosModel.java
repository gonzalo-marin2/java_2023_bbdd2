package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Alumno;
import service.FormacionServiceFactory;

public class TablaAlumnosModel extends AbstractTableModel {

	List<Alumno> alumnos;
	final int COLS=3;//DECLARAMOS UNA CONSTANTE PARA DEFINIR EL NÚMERO DE COLUMNAS
	
	//Aquí no necesitamos este constructor
	/*public TablaAlumnosModel() {
		alumnos=new FormacionService().alumnosCurso(0);//para mostrar todos los alumnos
	}*/
	
	public TablaAlumnosModel(int idCurso) {
		alumnos=FormacionServiceFactory.getFormacionService().alumnosCurso(idCurso);//para mostrar los alumnos por curso
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return alumnos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLS;
	}

	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "Nombre";
		case 1:
			return "DNI";
		case 2:
			return "Nota";
		default:
			return "Indeterminada";
		}
	}

	@Override
	public Object getValueAt(int row, int column) {//según el número de la fila, sacamos los diferentes valores
		switch(column) {
		case 0:
			return alumnos.get(row).getNombre();
		case 1:
			return alumnos.get(row).getDni();
		case 2:
			return alumnos.get(row).getNota();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
			return Double.class;
		default:
			return null;
		}
	}
}
