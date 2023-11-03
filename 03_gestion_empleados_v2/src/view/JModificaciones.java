package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.EmpleadosService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JModificaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEmpleado;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public JModificaciones() {
		setTitle("Modificaciones de salario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleado = new JLabel("IdEmpleado");
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmpleado.setBounds(45, 50, 125, 20);
		contentPane.add(lblEmpleado);
		
		JLabel lblNuevoSalario = new JLabel("Nuevo salario");
		lblNuevoSalario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNuevoSalario.setBounds(45, 117, 125, 20);
		contentPane.add(lblNuevoSalario);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setBounds(230, 50, 155, 20);
		contentPane.add(txtIdEmpleado);
		txtIdEmpleado.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(230, 117, 155, 20);
		contentPane.add(txtSalario);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadosService service=new EmpleadosService();
				service.modificarSalario(Double.parseDouble(txtSalario.getText()),Integer.parseInt(txtIdEmpleado.getText()));
				JModificaciones.this.dispose();
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(140, 200, 155, 30);
		contentPane.add(btnModificar);
		this.setVisible(true);
	}

}
