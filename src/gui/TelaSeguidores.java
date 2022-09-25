package gui;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import mytwitter.Perfil;

public class TelaSeguidores<E> extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private TelaMyTwitter telaMyTwitter;
	private JList<E> listaSeguidores;
	private JScrollPane scrollTelaSeguidores;
	
	public TelaSeguidores(TelaMyTwitter telaMyTwitter) {
		super(telaMyTwitter, "Seguidores", true);
		this.telaMyTwitter = telaMyTwitter;
		
		inicializaComponentes();
		
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 350);
		setLocationRelativeTo(telaMyTwitter);
		setResizable(false);
		setVisible(true);
	}
	
	private void inicializaComponentes() {
		
		Vector<String> seguidores = new Vector<String>();
		
		for (Perfil p : telaMyTwitter.getPerfil().getSeguidores()) {
			seguidores.add(p.getUsuario());
		}

		listaSeguidores = new JList(seguidores);
		listaSeguidores.setEnabled(false);
		
		scrollTelaSeguidores = new JScrollPane(listaSeguidores,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTelaSeguidores.setBounds(16, 20, 250, 270);
		scrollTelaSeguidores.setViewportView(listaSeguidores);
		add(scrollTelaSeguidores);
	}

}
