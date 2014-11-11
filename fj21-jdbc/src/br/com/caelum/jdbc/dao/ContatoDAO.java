package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	private Connection connection;
	//construtor da classe
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "insert into contatos"+
					"(nome, email, endereco, dataNascimento)"+
					" values (?, ?,?,?)";
	
		try{
			PreparedStatement stmt =  connection.prepareStatement(sql);
			
			//set values
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			//stmt.setDate(4, new Date(contato.getDataNascimento().getCalendar().getTimeInMillis()));
			
			//execute
			stmt.execute();
			stmt.close();
			
					
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome = ?, email = ?, endereco = ?,"
					  +"dataNascimento = ? where id = ?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			throw new DAOException();
		}
				
		
	}
	
	
	public Contato search(int id){
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = "+id);
			ResultSet rs = stmt.executeQuery();
			rs.next(); //obrigatorio para iterar a lista
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setName(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			//montando para receber calendario
			 Calendar data = Calendar.getInstance();
             data.setTime(rs.getDate("dataNascimento"));
             contato.setDataNascimento(data);
 
            rs.close();
     		stmt.close();
     	    return contato;
         
		} catch (SQLException e) {
			throw new DAOException ();
		}
		
		
		
	}
	
	 public void remove(Contato contato) {
	     try {
	         PreparedStatement stmt = connection.prepareStatement("delete" +
	                 " from contatos where id=?");
	         stmt.setLong(1, contato.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public List<Contato> getLista(){
		try{
			//array list de contatos
			List<Contato>contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");//ta instanciando
			ResultSet rs = stmt.executeQuery(); 
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				//montando para receber calendario
				 Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             contato.setDataNascimento(data);
	             
				//adicionando contatos a lista
				
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		}
		catch(SQLException e){
			throw new DAOException ();
		}
	}
	public void close() throws SQLException{
		connection.close();
	} 

}
