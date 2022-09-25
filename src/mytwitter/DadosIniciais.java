package mytwitter;

import java.util.Vector;

public class DadosIniciais {
	
	public static Vector<Perfil> getDadosIniciais() {
		Vector<Perfil> perfisPessoaFisica = new Vector<Perfil>();
		
		for (int i = 0; i < 10; i++) {
			PessoaFisica pf = new PessoaFisica("pessoa_fisica_" + i);
			pf.setCpf(Long.valueOf("01234567890"+i));
			perfisPessoaFisica.add(pf);
			for (int j = 1; j <= 3; j++) {
				Tweet t = new Tweet();
				t.setUsuario(pf.getUsuario());
				t.setMensagem(i + j + " O incentivo ao avanço tecnológico, assim como a hegemonia do ambiente "
						+ "político apresenta tendências no sentido de aprovar a manutenção de "
						+ "todos os recursos funcionais envolvidos.");
				perfisPessoaFisica.get(i).addTweet(t);
				
			}
		}
		
		Vector<Perfil> perfisPessoaJuridica = new Vector<Perfil>();
		
		for (int i = 0; i < 10; i++) {
			PessoaJuridica pj = new PessoaJuridica("pessoa_juridica_" + i);
			pj.setCnpj(Long.valueOf("01234567890000"+i));
			perfisPessoaJuridica.add(pj);
			for (int j = 1; j <= 3; j++) {
				Tweet t = new Tweet();
				t.setUsuario(pj.getUsuario());
				t.setMensagem(i + j + " O empenho em analisar a adoção de políticas descentralizadoras obstaculiza a "
						+ "apreciação da importância dos conhecimentos estratégicos para atingir a excelência.");
				perfisPessoaJuridica.get(i).addTweet(t);
				
			}
		}
		
		//pessoa_fisica_0 segue pessoa_fisica_1
		perfisPessoaFisica.get(0).addSeguindo(perfisPessoaFisica.get(1));
		perfisPessoaFisica.get(1).addSeguidor(perfisPessoaFisica.get(0));
		
		Vector<Perfil> perfis = new Vector<Perfil>();
		perfis.addAll(perfisPessoaFisica);
		perfis.addAll(perfisPessoaJuridica);
		
		return perfis;
	}

}
