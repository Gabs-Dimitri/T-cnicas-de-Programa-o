package mytwitter;
import java.util.Vector;

public class Perfil {
	private String usuario;
	private Vector<Perfil> seguidores;
	private Vector<Perfil> seguindo;
	private Vector<Tweet> timeline;
	private boolean ativo;
	
	public Perfil(String usuario) {
		this.usuario = usuario;
		seguidores = new Vector<Perfil>();
		seguindo = new Vector<Perfil>();
		timeline = new Vector<Tweet>();
		ativo = true;
	}
	
	public void addSeguidor(Perfil perfil) {
		seguidores.add(perfil);
	}
	
	public void addSeguindo(Perfil perfil) {
		seguindo.add(perfil);
	}
	
	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;	
	}
	
	public Vector<Perfil> getSeguidores(){
		return seguidores;
	}
	
	public Vector<Perfil> getSeguindo() {
		return seguindo;
	}
	
	public Vector<Tweet> getTimeline(){
		return timeline;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
}
