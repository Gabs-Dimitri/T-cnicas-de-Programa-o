package mytwitter;
import java.util.Vector;

public interface ITwitter {
	
	public void criarPerfil(Perfil usuario);
	
	public void cancelarPerfil(String usuario);
	
	public void tweetar(String usuario, String mensagem);
	
	public Vector<Tweet> timeline(String usuario);
	
	public Vector<Tweet> tweets(String usuario);
	
	public void seguir(String seguidor, String seguido);
	
	public int numeroSeguidores(String usuario);
	
	public Vector<Perfil> seguidores(String usuario);
	
	public int numeroSeguindo(String usuario);
	
	public Vector<Perfil> seguindo(String usuario);
	
	public Perfil buscarPerfil(String usuario);
	
}
