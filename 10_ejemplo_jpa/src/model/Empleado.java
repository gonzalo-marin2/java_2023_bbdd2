package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="empleados")

public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//al ser idEmpleado autogenerado, hace falta esta línea
	private int idEmpleado;
	private String nombre;
	private String email;
	private String departamento;
	private double salario;
}
