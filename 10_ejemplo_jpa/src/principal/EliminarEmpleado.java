package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class EliminarEmpleado {

	public static void main(String[] args) {
		//CREACIÓN DEL ENTITY MANAGER
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em=factory.createEntityManager();
		//ELIMINAR EMPLEADO DE CÓDIGO 5
		//USAMOS MÉTODO REMOVE()
		//PRIMERO BUSCAMOS EL EMPLEADO
		Empleado emp=em.find(Empleado.class, 5);
		if(emp!=null) {
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(emp);
			tx.commit();
			System.out.println("Eliminado");
		}else {
			System.out.println("No existe");
		}

	}

}
