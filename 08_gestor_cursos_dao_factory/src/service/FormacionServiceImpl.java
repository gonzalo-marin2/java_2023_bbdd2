package service;

import java.util.List;

import javax.swing.JOptionPane;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.CursosJsonDao;
import dao.DaoFactory;
import model.Alumno;
import model.Curso;

public class FormacionServiceImpl implements FormacionService {
	
	@Override
	public void actualizarDatos() {
		var cursosService=DaoFactory.getCursosDao();
		var alumnosService=DaoFactory.getAlumnosDao();
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
	
	@Override
	public List<Curso> listadoCursos(){
		var cursosDao=DaoFactory.getCursosDao();
		return cursosDao.cursos();
	}
	
	@Override
	public List<Alumno> alumnosCurso(int idCurso){//si pasan cero, quieren todos los alumnos
		var alumnosDao=DaoFactory.getAlumnosDao();
		/*if(idCurso==0) {
			return alumnosDao.alumnos();
		}
		return alumnosDao.alumnos(idCurso);*/
		
		return idCurso==0?alumnosDao.alumnos():alumnosDao.alumnos(idCurso);
	}
	
	//devuelve falso sino existe o ha fallado la eliminación
	//devuelve verdadero si se ha podido eliminar de la base de datos
	@Override
	public boolean eliminarAlumno(String dni) {
		var alumnosDao=DaoFactory.getAlumnosDao();
		if(!alumnosDao.existeAlumno(dni)) {
			return false;//no existe alumno
		}
		return alumnosDao.eliminarAlumno(dni);
	}
	

}
