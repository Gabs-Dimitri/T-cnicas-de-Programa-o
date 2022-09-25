package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mytwitter.MyTwitter;
import mytwitter.Perfil;

public class TelaBuscarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private TelaMyTwitter telaMytwitter;
	private MyTwitter myTwitter;
	
	private JLabel labelBuscarUsuario;
	private JTextField fieldBuscaUsuario;
	private JButton buttonBuscar;
	private JLabel labelUsuarioPesquisado;
	private JButton buttonSeguir;
	
	public TelaBuscarUsuario(TelaMyTwitter telaMyTwitter, MyTwitter myTwitter) {
		super(telaMyTwitter, "Buscar usuário", true);
		this.telaMytwitter = telaMyTwitter;
		this.myTwitter = myTwitter;
		
		inicializaComponentes();
		
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 220);
		setLocationRelativeTo(telaMyTwitter);
		setResizable(false);
		setVisible(true);
	}
	
	private void inicializaComponentes() {
		
		labelBuscarUsuario = new JLabel("Nome do usuário:");
		labelBuscarUsuario.setBounds(32, 20, 100, 30);
		add(labelBuscarUsuario);
		
		fieldBuscaUsuario = new JTextField();
		fieldBuscaUsuario.setBounds(30, 42, 230, 20);
		fieldBuscaUsuario.addKeyListener(new KeyListener(){
			
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
					actionButtonBuscar();
				}
				
			}
		});
		add(fieldBuscaUsuario);
		
		buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(90, 80, 100, 22);
		buttonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				actionButtonBuscar();
			}
		});
		add(buttonBuscar);
		
		labelUsuarioPesquisado = new JLabel("");
		labelUsuarioPesquisado.setBounds(32, 120, 120, 22);
		labelUsuarioPesquisado.setVisible(false);
		add(labelUsuarioPesquisado);
		
		buttonSeguir = new JButton("Seguir");
		buttonSeguir.setBounds(180, 120, 80, 22);
		buttonSeguir.setVisible(false);
		buttonSeguir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myTwitter.seguir(telaMytwitter.getPerfil().getUsuario(), labelUsuarioPesquisado.getText());
				setVisible(false);
				telaMytwitter.getButtonSeguindo().setText(telaMytwitter.getPerfil().getSeguindo().size() + " seguindo");
				telaMytwitter.atualizarTimeline();
			}
		});
		add(buttonSeguir);
	}
	
	private void actionButtonBuscar() {
		
		labelUsuarioPesquisado.setText("");
		labelUsuarioPesquisado.setVisible(false);
		buttonSeguir.setVisible(false);
		
		if (fieldBuscaUsuario.getText().length() > 0) {
			Perfil perfilBuscado = myTwitter.buscarPerfil(fieldBuscaUsuario.getText());
			if (perfilBuscado != null) {
				labelUsuarioPesquisado.setText(perfilBuscado.getUsuario());
				labelUsuarioPesquisado.setVisible(true);
				
				buttonSeguir.setVisible(true);
				
				if (isSeguindo(perfilBuscado.getUsuario()) || perfilBuscado.getUsuario().equals(telaMytwitter.getPerfil().getUsuario())) {
					buttonSeguir.setEnabled(false);
				} else {
					buttonSeguir.setEnabled(true);
				}
			} else {
				JOptionPane.showMessageDialog(null,	"Usuário não encontrado!", 
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
			
		} else if(fieldBuscaUsuario.getText().length() == 0) {
			JOptionPane.showMessageDialog(null,	"Digite um nome para pesquisa!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private boolean isSeguindo(String usuario) {
		for (Perfil p : telaMytwitter.getPerfil().getSeguindo()) {
			if (p.getUsuario().equals(usuario)) {
				return true;
			}
		}
		
		return false;
	}

}
