package br.com.caelum.jdbc.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Contato{
		private Long id;
		private String name;
		private String email;
		private String endereco;
		private Calendar dataNascimento;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public Calendar getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Calendar dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		
		
}


