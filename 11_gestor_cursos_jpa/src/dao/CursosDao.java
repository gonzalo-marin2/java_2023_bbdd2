package dao;

import java.time.LocalDate;
import java.util.List;

import model.Curso;

public interface CursosDao {

	boolean existeCurso(int idCurso);

	boolean guardarCurso(Curso curso);

	List<Curso> cursos();
	
	List<Curso> buscarCursos(LocalDate fInicio, LocalDate fFin);

}