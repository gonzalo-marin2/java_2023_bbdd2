package view;

import java.awt.EventQueue;
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

import model.Usuario;
import service.UsuarioService;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtUsuario;
	private JTextField jtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(60, 35, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(60, 90, 100, 30);
		contentPane.add(lblNewLabel_1);
		
		jtUsuario = new JTextField();
		jtUsuario.setBounds(210, 35, 100, 30);
		contentPane.add(jtUsuario);
		jtUsuario.setColumns(10);
		
		jtPassword = new JTextField();
		jtPassword.setBounds(210, 90, 100, 30);
		contentPane.add(jtPassword);
		jtPassword.setColumns(10);
		
		JButton btEntrar = new JButton("ENTRAR");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService service=new UsuarioService();//Creamos un objeto de la clase UsuarioService
				Usuario usuario=new Usuario(jtUsuario.getText(),jtPassword.getText());//Creamos un objeto Usuario
				//con los atributos que recogemos de los campos de texto
				if(service.autenticar(usuario)) {//llamamos al método y, como parámetro, el objeto Usuario que hemos creado antes
					JOptionPane.showMessageDialog(JLogin.this, "Usuario válido");
				}else {
					JOptionPane.showMessageDialog(JLogin.this, "Usuario incorrecto");
				}		
			}
		});
		
		btEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btEntrar.setBounds(150, 160, 100, 30);
		contentPane.add(btEntrar);
	}

}
