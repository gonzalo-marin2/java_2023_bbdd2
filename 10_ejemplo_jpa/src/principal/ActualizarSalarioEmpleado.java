package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ActualizarSalarioEmpleado {

	public static void main(String[] args) {
		double factor=1.1;//subimos un 10%
		String dep="informática";
		//CREACIÓN DEL ENTITY MANAGER
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		String jpql="update Empleado e set e.salario=e.salario*?1 where e.departamento=?2";
		Query q=em.createQuery(jpql);
		q.setParameter(1, factor);
		q.setParameter(2, dep);
		//q.executeUpdate();==>devuelve un número que es el número de objetos actualizados
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		int res=q.executeUpdate();
		tx.commit();
		System.out.println("Se actualizaron "+res+" empleados");	
	}

}
