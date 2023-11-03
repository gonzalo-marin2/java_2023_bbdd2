package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaEmpleadosModel;

public class JBuscarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDep;
	private JTable tbEmpleados;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JBuscarEmpleado() {
		setTitle("Buscar empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Nombre Departamento");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartamento.setBounds(35, 10, 150, 30);
		contentPane.add(lblDepartamento);
		
		txtDep = new JTextField();
		txtDep.setBounds(195, 10, 205, 30);
		contentPane.add(txtDep);
		txtDep.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*var service=new EmpleadosService();
				service.empleadosPorDepartamento(txtDep.getText());*/
				tbEmpleados.setModel(new TablaEmpleadosModel(txtDep.getText()));//aplicamos a la tabla el modelo de tabla
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(102, 62, 205, 38);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 128, 365, 122);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		this.setVisible(true);
	}
}
