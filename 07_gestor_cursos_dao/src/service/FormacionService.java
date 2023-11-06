package service;

import java.util.List;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.CursosJsonDao;
import model.Alumno;
import model.Curso;

public class FormacionService {
	
	public void actualizarDatos() {
		var cursosService=new CursosDao();
		var alumnosService=new AlumnosDao();
		var jsonDao=new CursosJsonDao();
		jsonDao.cursos()//recorremos cursos
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
	
	public List<Curso> listadoCursos(){
		var cursosDao=new CursosDao();
		return cursosDao.cursos();
	}
	
	public List<Alumno> alumnosCurso(int idCurso){//si pasan cero, quieren todos los alumnos
		var alumnosDao=new AlumnosDao();
		/*if(idCurso==0) {
			return alumnosDao.alumnos();
		}
		return alumnosDao.alumnos(idCurso);*/
		
		return idCurso==0?alumnosDao.alumnos():alumnosDao.alumnos(idCurso);
	}
	

}
