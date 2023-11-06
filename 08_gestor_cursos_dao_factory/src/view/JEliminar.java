package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.FormacionServiceFactory;

public class JEliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JEliminar() {
		setTitle("Eliminar alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=FormacionServiceFactory.getFormacionService();
				String mensaje;
				if(service.eliminarAlumno(txtDni.getText())) {
					mensaje="Alumno eliminado satisfactoriamente";
				}else {
					mensaje="Error, el alumno no existe";
				}
				JOptionPane.showMessageDialog(JEliminar.this,mensaje);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(105, 141, 238, 40);
		contentPane.add(btnEliminar);
		
		JLabel lblDni = new JLabel("Introduce DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(25, 45, 107, 26);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(190, 49, 153, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		this.setVisible(true);
	}
}
