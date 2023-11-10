package principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Empleado;

public class BusquedaEmpleado {

	public static void main(String[] args) {
		//CREACIÓN DEL ENTITY MANAGER
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		//BUSCAR EMPLEADO CUYO IDEMPLEADO SEA 5
		//USAMOS MÉTODO FIND()
		Empleado empleado=em.find(Empleado.class, 5);
		if(empleado!=null) {
			System.out.println(empleado.getNombre());
		}else {
			System.out.println("No existe");
		}
		
		//buscar empleados del departamento Ventas
		String dep="comercial";
		String jpql="select e from Empleado e where e.departamento=?1";
		TypedQuery<Empleado> tq=em.createQuery(jpql, Empleado.class);
		tq.setParameter(1, dep);
		List<Empleado> emps=tq.getResultList();
		emps.forEach(e->System.out.println(e.getNombre()));
	}

}
