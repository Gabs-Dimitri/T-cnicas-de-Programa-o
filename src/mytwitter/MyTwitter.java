package mytwitter;
import java.util.Vector;

public class MyTwitter implements ITwitter{

	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public void criarPerfil(Perfil usuario) {
		
		repositorio.cadastrar(usuario);
	
	}
	
	@Override
	public void cancelarPerfil(String usuario) { //alterar o perfil para inativo. caso já esteja desativado, levantar msg PDException. Caso perfil não existe, levantar PIException
		
		Perfil perfil = repositorio.buscar(usuario);
		
		if(perfil != null) {
			if(perfil.isAtivo()) {
				perfil.setAtivo(false);
				repositorio.atualizar(perfil);
			}else {
				throw new PDException("Perfil desativado");
			}
			
		}else {
			throw new PIException("Perfil inexistente");
		}
			
	}

	@Override
	public void tweetar(String usuario, String mensagem) { 
		Perfil perfil = repositorio.buscar(usuario);
		
		Tweet tweet = new Tweet();
		tweet.setUsuario(usuario);
		tweet.setMensagem(mensagem);
		
		perfil.addTweet(tweet);
	}

	@Override
	public Vector<Tweet> timeline(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		Vector<Tweet> timeline = new Vector<Tweet>();
		for (Perfil perfilSeguindo : perfil.getSeguindo()) {
			for (Tweet tweet : perfilSeguindo.getTimeline()) {
				timeline.add(tweet);
			}
		}
		
		return timeline;
	}

	@Override
	public Vector<Tweet> tweets(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		Vector<Tweet> meusTweets = new Vector<Tweet>();
		for (Tweet tweet : perfil.getTimeline()) {
			meusTweets.add(tweet);
		}
		
		return meusTweets;
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		Perfil perfilSeguidor = repositorio.buscar(seguidor);
		Perfil perfilSeguido = repositorio.buscar(seguido);
		
		perfilSeguidor.addSeguindo(perfilSeguido);
		perfilSeguido.addSeguidor(perfilSeguidor);
	}

	@Override
	public int numeroSeguidores(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		return perfil.getSeguidores().size();
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		return perfil.getSeguidores();
	}

	@Override
	public int numeroSeguindo(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		return perfil.getSeguindo().size();
	}

	@Override
	public Vector<Perfil> seguindo(String usuario) {
		Perfil perfil = repositorio.buscar(usuario);
		
		return perfil.getSeguindo();
	}

	@Override
	public Perfil buscarPerfil(String usuario) {
		return repositorio.buscar(usuario);
	}
	
}
