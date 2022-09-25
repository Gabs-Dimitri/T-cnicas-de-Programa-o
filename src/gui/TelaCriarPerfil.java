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
import mytwitter.PessoaFisica;
import mytwitter.PessoaJuridica;

public class TelaCriarPerfil extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelNomePerfil;
	private JTextField fieldNomePerfil;
	private JLabel labelNumeroCpfCnpj;
	private JTextField fieldNumeroCpfCnpj;
	private JButton buttonPerfilPessoa;
	private JButton buttonPerfilEmpresa;
	
	private MyTwitter myTwitter;
	
	public TelaCriarPerfil(TelaLogin telaLogin, MyTwitter myTwitter) {
		super(telaLogin, "Criar Perfil", true);
		
		this.myTwitter = myTwitter;
		
		inicializaComponentes();
		
		setTitle("Criar Perfil");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(493, 223, 400, 270);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(telaLogin);
		
	}

	private void inicializaComponentes() {
		
		labelNomePerfil = new JLabel("Digite um nome a ser usado: ");
		labelNomePerfil.setBounds(25, 20, 200, 30);
		add(labelNomePerfil);
		
		fieldNomePerfil = new JTextField();
		fieldNomePerfil.setBounds(25, 42, 330, 20);
		add(fieldNomePerfil);
		
		labelNumeroCpfCnpj = new JLabel("Digite o número do cpf ou cnpj:  ");
		labelNumeroCpfCnpj.setBounds(25, 65, 200, 30);
		add(labelNumeroCpfCnpj);
		
		fieldNumeroCpfCnpj = new JTextField();
		fieldNumeroCpfCnpj.setBounds(25, 87, 330, 20);
		fieldNumeroCpfCnpj.addKeyListener(new KeyListener(){
			
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == e.VK_BACK_SPACE || (e.getKeyChar() == e.VK_0)|| (e.getKeyChar() == e.VK_1)|| (e.getKeyChar() == e.VK_2) 
			            || (e.getKeyChar() == e.VK_3)|| (e.getKeyChar() == e.VK_4)|| (e.getKeyChar() == e.VK_5)|| (e.getKeyChar() == e.VK_6)|| (e.getKeyChar() == e.VK_7)
			            || (e.getKeyChar() == e.VK_8)|| (e.getKeyChar() == e.VK_9)||(e.getKeyChar() == e.VK_ENTER)) {
					
				} else {
					e.consume();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		add(fieldNumeroCpfCnpj);
		
		buttonPerfilPessoa = new JButton("Criar perfil pessoa");
		buttonPerfilPessoa.setBounds(115, 130, 150, 22);
		buttonPerfilPessoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				criarPerfilPessoa();
			}
		});
		add(buttonPerfilPessoa);
		
		buttonPerfilEmpresa = new JButton("Criar perfil empresa");
		buttonPerfilEmpresa.setBounds(115, 160, 150, 22);
		buttonPerfilEmpresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				criarPerfilEmpresa();
			}
		});
		add(buttonPerfilEmpresa);
		
	}
	
	private void criarPerfilPessoa() {
		
		PessoaFisica perfil = null;
		if (fieldNomePerfil.getText().trim().length() > 0) {
			if (fieldNumeroCpfCnpj.getText().length() == 11) {
				perfil = new PessoaFisica(fieldNomePerfil.getText());
				perfil.setCpf(Long.parseLong(fieldNumeroCpfCnpj.getText()));
				myTwitter.criarPerfil(perfil);
				
				JOptionPane.showMessageDialog(null,	"Usuário cadastrado com sucesso!", 
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,	"CPF inválido!", 
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null,	"Digite o nome de um usuário!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void criarPerfilEmpresa() {
		
		PessoaJuridica perfil = null;
		if (fieldNomePerfil.getText().trim().length() > 0) {
			if (fieldNumeroCpfCnpj.getText().length() == 14) {
				perfil = new PessoaJuridica(fieldNomePerfil.getText());
				perfil.setCnpj(Long.parseLong(fieldNumeroCpfCnpj.getText()));
				myTwitter.criarPerfil(perfil);
				
				JOptionPane.showMessageDialog(null,	"Usuário cadastrado com sucesso!", 
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,	"CNPJ inválido!", 
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null,	"Digite o nome de um usuário!", 
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
