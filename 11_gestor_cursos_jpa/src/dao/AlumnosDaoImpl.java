package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import helpers.EntityManagerLocator;
import model.Alumno;//como solo hay uno, lo escribimos
public class AlumnosDaoImpl implements AlumnosDao {
	
	@Override
	public boolean existeAlumno(String dni) {
		return EntityManagerLocator.getEntityManager().find(Alumno.class, dni)!=null;
	}
	
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		try {
			//al no tener la importación estática como en cursosdaoimpl, hay que llamar a la clase EntityManagerLocator
			//para que nos traiga el método getEntityManager
			EntityManager em=EntityManagerLocator.getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(alumno);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//PARA GUARDAR DE GOLPE MUCHOS ALUMNOS
	@Override
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try {
			EntityManager em=EntityManagerLocator.getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			for(Alumno alumno:alumnos) {
				EntityManagerLocator.getEntityManager().persist(alumno);
			}
			
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public List<Alumno> alumnos() {
	
		EntityManager em=EntityManagerLocator.getEntityManager();
		String jpql="select a from Alumno a";
		TypedQuery<Alumno> tq=em.createQuery(jpql, Alumno.class);
		return tq.getResultList();
	}
	
	@Override
	public List<Alumno> alumnos(int curso) {
		EntityManager em=EntityManagerLocator.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		String jpql="select a from Alumno a where a.curso=?1";
		/*TypedQuery<Alumno> tq=em.createQuery(jpql, Alumno.class);
		tq.setParameter(1, curso);
		return tq.getResultList();*/
		return em
				.createQuery(jpql, Alumno.class)//TypedQuery
				.setParameter(1, curso)
				.getResultList();
	}
	
	@Override
	public boolean eliminarAlumno(String dni) {
		EntityManager em=EntityManagerLocator.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		String jpql="delete from Alumno a where a.dni=?1";
		tx.begin();
		int res=em
				.createQuery(jpql)
				.setParameter(1, dni)
				.executeUpdate();//devuelve true si elimina, devuelve false sino lo hace
		tx.commit();
		return res>0;
		/*Query q=em.createQuery(jpql);
		q.setParameter(1, dni);
		tx.begin();
		tx.executeUpdate();
		tx.commit();
		*/
		
	}
}
