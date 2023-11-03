package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {
	private int idEmpleado;
	private String nombre;
	private String email;
	private String departamento;
	private double salario;
	
	//Con este constructor, no necesitamos poner el 0 en la clase de prueba
	public Empleado(String nombre, String email, String departamento, double salario) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.departamento = departamento;
		this.salario = salario;
	}
	
	
	
}
