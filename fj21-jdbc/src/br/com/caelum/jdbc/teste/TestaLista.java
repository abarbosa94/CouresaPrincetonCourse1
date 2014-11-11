package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	
	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();
		for(Contato contato: contatos){
			System.out.println("ID: "+contato.getId());
			System.out.println("Nome: "+contato.getName());
			System.out.println("Email: "+contato.getEmail());
			System.out.println("Endereco: "+contato.getEndereco());
			//System.out.println("Data de Nascimento: "+contato.getDataNascimento().getTime()+ "\n");
			SimpleDateFormat formattation = new SimpleDateFormat("dd/MM/yyyy");
			String changed = formattation.format(contato.getDataNascimento().getTime());
			System.out.println("Data de Nascimento: "+changed + "\n");
		}
		
	}

}
