package mytwitter;
//Nessa parte, criei uma lista que vai guardar todos os usuários cadastrados. 
import java.util.Vector;

public class RepositorioUsuario implements IRepositorioUsuario {
	
	private Vector<Perfil> perfis;
	
	public RepositorioUsuario() {
		this.perfis = new Vector<Perfil>();
		
		perfis = DadosIniciais.getDadosIniciais();
	}

	@Override
	public void cadastrar(Perfil usuario) {
		
		boolean igual = false;
		
		for(int i = 0; i < perfis.size(); i++) {
			if (perfis.get(i).getUsuario().equals(usuario.getUsuario())) {
				igual = true;
				break;
			}
		}
		
		if (igual) {
			throw new UJCException("Usuario já cadastrado");
		} else {
			perfis.add(usuario);
		}
		
	}

	@Override
	public Perfil buscar(String usuario) {
		
		for(int i = 0; i < perfis.size(); i++) {
			if(perfis.get(i).getUsuario().equals(usuario) && perfis.get(i).isAtivo()) {
				return perfis.get(i);
			}
		}
		return null;
	}

	@Override
	public void atualizar(Perfil usuario) {
		
		boolean existe = false;
		
		for(int i = 0; i < perfis.size(); i++) {
			if (perfis.get(i).getUsuario().equals(usuario.getUsuario())) {
				existe = true;
				perfis.remove(i);
				perfis.add(usuario);
				break;
			}
		}
		
		if (!existe) {
			throw new UNCException("Usuario não cadastrado");
		} 
			
	}  
	
	
}
