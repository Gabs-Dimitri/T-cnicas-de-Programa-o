package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mytwitter.MyTwitter;
import mytwitter.Perfil;
import mytwitter.RepositorioUsuario;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelUsuario;
	private JTextField fieldUsuario;
	private JButton buttonLogin;
	private JButton buttonCriarPerfil;
	
	private RepositorioUsuario repositorio;
	private MyTwitter myTwitter;
	
	public TelaLogin() {
		
		repositorio = new RepositorioUsuario();
		myTwitter = new MyTwitter(repositorio);
		
		inicializaComponentes();
		
		setTitle("My Twitter");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 220);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	private void inicializaComponentes() {

		labelUsuario = new JLabel("Nome do usuário:");
		labelUsuario.setBounds(32, 20, 150, 30);
		add(labelUsuario);
		
		fieldUsuario = new JTextField();
		fieldUsuario.setBounds(30, 42, 230, 20);
		fieldUsuario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
				
			}
		});
		add(fieldUsuario);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(70, 80, 150, 22);
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				login();
			}
		});
		add(buttonLogin);
		
		buttonCriarPerfil = new JButton("Criar Perfil");
		buttonCriarPerfil.setBounds(70, 110, 150, 22);
		buttonCriarPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				new TelaCriarPerfil(null, myTwitter);
			}
		});
		add(buttonCriarPerfil);
		
	}
	
	private void login() {
		
		if (fieldUsuario.getText().trim().length() > 0) {
			Perfil perfil = myTwitter.buscarPerfil(fieldUsuario.getText());

			if (perfil != null) {
				new TelaMyTwitter(myTwitter, perfil);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,	"Usuário não encontrado!", 
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null,	"Digite o nome de um usuário!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new TelaLogin();
	}
	

}
