package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaConexao {


	public static void main(String[] args) throws SQLException {
		/*EXERCICIO UM
		 * Connection connection = new ConnectionFactory().getConnection();		 
		System.out.println("Conexão aberta !");
		connection.close();*/
		
		//pronto para gravar
		Contato contato = new Contato();
		/*contato.setName("Bruno");
		contato.setEmail("eae@champs.com.br");
		contato.setEndereco("R. Vigario Albernazia");
		contato.setDataNascimento(Calendar.getInstance());*/
		
	
		
		//gravando no banco
		ContatoDAO dao = new ContatoDAO(); //instance object, using getConnection()
		contato = dao.search(3);
		//dao.adiciona(contato);
		//dao.altera(contato);
		dao.remove(contato);
		System.out.println("Gravado !");

	}

}
