package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Curso;
import service.FormacionServiceFactory;

public class JComboCursosModel extends DefaultComboBoxModel<Curso> {
	List<Curso> cursos;
	public JComboCursosModel() {
		cursos=new ArrayList<>(FormacionServiceFactory.getFormacionService().listadoCursos());
		//añadimos otro null por la fecha
		cursos.add(0, new Curso(0,"-Todos-",0,0,null,null));//agregamos la opción "todos" al combobox, en la primera posición
	}
	
	@Override
	public int getSize() {
		return cursos.size();
	}
	@Override
	public Curso getElementAt(int index) {
		return cursos.get(index);
	}
	
	
}
