package dao;

import static helpers.EntityManagerLocator.getEntityManager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;

import model.Curso;
public class CursosDaoImpl implements CursosDao {

	@Override
	public boolean existeCurso(int idCurso) {
		return getEntityManager().find(Curso.class, idCurso)!=null;
	}
	
	@Override
	public boolean guardarCurso(Curso curso) {
		try {
			//gracias a la importación estática import static helpers.EntityManagerLocator.*; 
			//no tenemos que llamar a la clase EntityManagerLocator para llamar al método getEntityManager
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(curso);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Curso> cursos() {
		String jpql="select c from Curso c";
		return getEntityManager()
				.createQuery(jpql, Curso.class)
				.getResultList();
	}

	public List<Curso> buscarCursos(LocalDate fInicio, LocalDate fFin){
		String jpql="select c from Curso c where c.fechaInicio between ?1 and ?2";
		return getEntityManager()
				.createQuery(jpql, Curso.class)
				.setParameter(1, fInicio)
				.setParameter(2, fFin)
				.getResultList();		
	}
}
