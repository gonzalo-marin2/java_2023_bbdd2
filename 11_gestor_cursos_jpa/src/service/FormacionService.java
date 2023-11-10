package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	void actualizarDatos();

	List<Curso> listadoCursos();

	List<Alumno> alumnosCurso(int idCurso);

	//devuelve falso sino existe o ha fallado la eliminación
	//devuelve verdadero si se ha podido eliminar de la base de datos
	boolean eliminarAlumno(String dni);
	
	List<Curso> buscarCursos(LocalDate fInicio, LocalDate fFin);

}