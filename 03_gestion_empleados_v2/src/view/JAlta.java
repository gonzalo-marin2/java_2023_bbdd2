package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Empleado;
import service.EmpleadosService;

public class JAlta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtDepartamento;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JAlta() {
		setTitle("Altas de empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(35, 42, 100, 20);
		contentPane.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(35, 85, 100, 20);
		contentPane.add(lblEmail);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartamento.setBounds(35, 131, 100, 20);
		contentPane.add(lblDepartamento);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSalario.setBounds(35, 174, 100, 20);
		contentPane.add(lblSalario);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadosService service=new EmpleadosService();
				service.altaEmpleado(new Empleado(txtNombre.getText(),
									txtEmail.getText(),
									txtDepartamento.getText(),
									Double.parseDouble(txtSalario.getText())));
				//txtNombre.requestFocus();
				JAlta.this.dispose();
			}
		});
		btnGuardar.setBounds(154, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(220, 42, 120, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(220, 85, 120, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(220, 131, 120, 20);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(220, 174, 120, 20);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		this.setVisible(true);
	}
}
