package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import mytwitter.MyTwitter;
import mytwitter.Perfil;
import mytwitter.Tweet;

public class TelaMyTwitter extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MyTwitter myTwitter;
	private Perfil perfil;
	
	private JTextArea areaTweet;
	private JButton buttonTweet;
	private JScrollPane scrollAreaTweet;
	private JTextPane paneTimeline;
	private JScrollPane scrollPaneTimeline;
	private JLabel labelUsuario;
	private JButton buttonSeguidores;
	private JButton buttonSeguindo;
	private JButton buttonBuscarUsuario;
	private JLabel labelMeusTweets;
	private JTextPane paneMeusTweets;
	private JScrollPane scrollPaneMeusTweets;

	public TelaMyTwitter(MyTwitter myTwitter, Perfil perfil) {
		this.myTwitter = myTwitter;
		this.perfil = perfil;
		
		inicializaComponentes();
		
		setTitle("My Twitter");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void inicializaComponentes() {
		inicializaComponentesTweet();
	}
	
	private void inicializaComponentesTweet() {
		areaTweet = new JTextArea();
		areaTweet.setLineWrap(true);
		
		scrollAreaTweet = new JScrollPane(areaTweet,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAreaTweet.setBounds(20, 20, 350, 80);
		scrollAreaTweet.setViewportView(areaTweet);
		add(scrollAreaTweet);
		
		buttonTweet = new JButton("Tweetar");
		buttonTweet.setBounds(269, 105, 100, 22);
		buttonTweet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myTwitter.tweetar(perfil.getUsuario(), areaTweet.getText());
				atualizarMeusTweets();
			}
		});
		add(buttonTweet);
	
		paneTimeline = new JTextPane();
		paneTimeline.setEditable(false);
		paneTimeline.setContentType("text/html");
		paneTimeline.setText(getTimeline());
		
		scrollPaneTimeline = new JScrollPane(paneTimeline,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneTimeline.setBounds(20, 150, 350, 390);
		scrollPaneTimeline.setViewportView(paneTimeline);
		add(scrollPaneTimeline);
		
		labelUsuario = new JLabel("Olá, " + perfil.getUsuario() + "!");
		labelUsuario.setBounds(413, 20, 180, 20);
		labelUsuario.setFont(new Font("plain", Font.BOLD, 16));
		add(labelUsuario);

		buttonBuscarUsuario = new JButton("Buscar");
		buttonBuscarUsuario.setBounds(661, 20, 100, 22);
		buttonBuscarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaBuscarUsuario(TelaMyTwitter.this, myTwitter);
			}
		});
		add(buttonBuscarUsuario);
		
		buttonSeguidores = new JButton(perfil.getSeguidores().size() + " seguidores");
		buttonSeguidores.setBounds(413, 70, 150, 22);
		buttonSeguidores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaSeguidores(TelaMyTwitter.this);
			}
		});
		add(buttonSeguidores);
		
		buttonSeguindo = new JButton(perfil.getSeguindo().size() + " seguindo");
		buttonSeguindo.setBounds(582, 70, 150, 22);
		buttonSeguindo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaSeguindo(TelaMyTwitter.this);
			}
		});
		add(buttonSeguindo);
		
		
		labelMeusTweets = new JLabel("Meus Tweets");
		labelMeusTweets.setBounds(525, 120, 130, 20);
		labelMeusTweets.setFont(new Font("plain", Font.BOLD, 16));
		add(labelMeusTweets);
		
		paneMeusTweets = new JTextPane();
		paneMeusTweets.setEditable(false);
		paneMeusTweets.setContentType("text/html");
		paneMeusTweets.setText(getMeusTweets());
		
		scrollPaneMeusTweets = new JScrollPane(paneMeusTweets,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneMeusTweets.setBounds(413, 150, 350, 390);
		scrollPaneMeusTweets.setViewportView(paneMeusTweets);
		add(scrollPaneMeusTweets);
	
	}
	
	private String getMeusTweets() {
		Vector<Tweet> vectorMeusTweets = myTwitter.tweets(perfil.getUsuario());
		
		String meusTweets = "<html>";
		
		for (Tweet tweet : vectorMeusTweets) {
			meusTweets += "<b>" + tweet.getUsuario() + "</b><br><p>" + tweet.getMensagem() + "</p><hr>";
		}
		
		meusTweets += "</html>";
		
		return meusTweets;
	}
	
	private String getTimeline() {
		Vector<Tweet> vectorTimeline = myTwitter.timeline(perfil.getUsuario());
		
		String timeline = "<html>";
		
		for (Tweet tweet : vectorTimeline) {
			timeline += "<b>" + tweet.getUsuario() + "</b><br><p>" + tweet.getMensagem() + "</p><hr>";
		}
		
		timeline += "</html>";
		
		return timeline;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public JButton getButtonSeguindo() {
		return buttonSeguindo;
	}
	
	public void atualizarTimeline() {
		paneTimeline.setText(getTimeline());
	}
	
	public void atualizarMeusTweets() {
		paneMeusTweets.setText(getMeusTweets());
	}


}
