package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaBusca {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.search(1);
		System.out.println("Nome: "+contato.getName());
		System.out.println("Email: "+contato.getEmail());
		System.out.println("Endereco: "+contato.getEndereco());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String changed = format.format(contato.getDataNascimento().getTime());
		System.out.println("Data de Nascimento: "+changed);
	}

}
