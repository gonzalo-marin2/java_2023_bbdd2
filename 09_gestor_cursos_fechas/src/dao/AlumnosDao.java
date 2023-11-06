package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {

	boolean existeAlumno(String dni);

	boolean guardarAlumno(Alumno alumno);

	//PARA GUARDAR DE GOLPE MUCHOS ALUMNOS
	boolean guardarAlumnos(List<Alumno> alumnos);

	List<Alumno> alumnos();

	List<Alumno> alumnos(int curso);

	boolean eliminarAlumno(String dni);

}