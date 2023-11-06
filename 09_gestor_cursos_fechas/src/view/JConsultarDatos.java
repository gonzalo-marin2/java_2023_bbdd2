package view;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Curso;
import view.adapters.JComboCursosModel;
import view.adapters.TablaAlumnosModel;

public class JConsultarDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAlumnos;

	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */
	public JConsultarDatos() {
		setTitle("Consultar datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurso = new JLabel("Seleccione curso:");
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurso.setBounds(50, 20, 158, 25);
		contentPane.add(lblCurso);
		
		JComboBox cbCursos = new JComboBox();
		cbCursos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Curso curso=(Curso)cbCursos.getSelectedItem();//hacemos casting primero pq devuelve el objeto entero
				//cargamos el tablemodel con el id del curso seleccionado
				tbAlumnos.setModel(new TablaAlumnosModel(curso.getIdCurso()));
			}
		});
		cbCursos.setBounds(110, 65, 230, 25);
		contentPane.add(cbCursos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 136, 350, 114);
		contentPane.add(scrollPane);
		
		tbAlumnos = new JTable();
		scrollPane.setViewportView(tbAlumnos);
		
		cbCursos.setModel(new JComboCursosModel());//carga los cursos al abrirse la ventana
		
		this.setVisible(true);
	}
}
