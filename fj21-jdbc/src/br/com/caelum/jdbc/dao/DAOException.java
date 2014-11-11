package br.com.caelum.jdbc.dao;

public class DAOException extends RuntimeException {

	DAOException(){
		super("Problema ao acessar os dados");
	}

}
