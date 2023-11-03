package service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Curso;

public class FicheroService {
	//esta parte se encarga de leer el fichero. Nos lo devuelve en una lista
	public Stream<Curso> getCursos(){
		String ruta="c:\\temp\\cursos.json";
		Gson gson=new Gson();
		try(FileReader reader=new FileReader(ruta);){
			Curso[] cursos=gson.fromJson(reader, Curso[].class);
			return Arrays.stream(cursos);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Curso> cursos(){
		return getCursos()
				.collect(Collectors.toList());
	}
	
	public void actualizarDatos() {
		var cursosService=new CursosService();
		var alumnosService=new AlumnosService();
		cursos()//recorremos cursos
		.forEach(c->{
			if(!cursosService.existeCurso(c.getIdCurso())){//si curso no está en bd, se añade
				cursosService.guardarCurso(c);
			}
			//recorremos alumnos de cada curso
			c.getAlumnos().forEach(a->{
				if(!alumnosService.existeAlumno(a.getDni())) {
					a.setCurso(c.getIdCurso());//asignamos un curso al alumno antes de guardarlo
					alumnosService.guardarAlumno(a);
				}
			});
		
		});
	}
	
}
