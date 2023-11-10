package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaCursosModel;

public class JBuscarCursoFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF1;
	private JTextField txtF2;
	private JTable tbCursos;

	/**
	 * Create the frame.
	 */
	public JBuscarCursoFecha() {
		setTitle("Buscar curso por fecha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaInicio.setBounds(40, 11, 100, 40);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Fin");
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaFinal.setBounds(250, 11, 100, 40);
		contentPane.add(lblFechaFinal);
		
		txtF1 = new JTextField();
		txtF1.setBounds(40, 58, 100, 20);
		contentPane.add(txtF1);
		txtF1.setColumns(10);
		
		txtF2 = new JTextField();
		txtF2.setBounds(250, 58, 100, 20);
		contentPane.add(txtF2);
		txtF2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 129, 362, 107);
		contentPane.add(scrollPane);
		
		tbCursos = new JTable();
		scrollPane.setViewportView(tbCursos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					var f1=LocalDate.parse(txtF1.getText());
					var f2=LocalDate.parse(txtF2.getText());
					tbCursos.setModel(new TablaCursosModel(f1,f2));
				}
				catch(DateTimeParseException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(JBuscarCursoFecha.this, "Error en las fechas");
				}
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(151, 95, 89, 23);
		contentPane.add(btnBuscar);
		this.setVisible(true);
	}
}
