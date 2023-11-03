package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private List<Alumno> alumnos;//creamos esta lista pq en el json hay una categoría alumnos que no está en la base de datos
}
