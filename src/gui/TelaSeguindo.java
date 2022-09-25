package gui;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import mytwitter.Perfil;

public class TelaSeguindo<E> extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private TelaMyTwitter telaMyTwitter;
	private JList<E> listaSeguindo;
	private JScrollPane scrollTelaSeguindo;
	
	public TelaSeguindo(TelaMyTwitter telaMyTwitter) {
		super(telaMyTwitter, "Seguindo", true);
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
		
		Vector<String> seguindo = new Vector<String>();
		
		for (Perfil p : telaMyTwitter.getPerfil().getSeguindo()) {
			seguindo.add(p.getUsuario());
		}

		listaSeguindo = new JList(seguindo);
		listaSeguindo.setEnabled(false);
		
		scrollTelaSeguindo = new JScrollPane(listaSeguindo,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTelaSeguindo.setBounds(16, 20, 250, 270);
		scrollTelaSeguindo.setViewportView(listaSeguindo);
		add(scrollTelaSeguindo);
	}

}
