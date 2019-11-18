package br.com.controledepresenca.mvc.model.persistent_object;

public class POPalestrante {
	
	/*
	+-------+--------------+------+-----+---------+----------------+
	| Field | Type         | Null | Key | Default | Extra          |
	+-------+--------------+------+-----+---------+----------------+
	| id    | int(11)      | NO   | PRI | NULL    | auto_increment |
	| nome  | varchar(100) | NO   |     | NULL    |                |
	+-------+--------------+------+-----+---------+----------------+
	*/
	
	protected int idPalestrante;
	protected String nome;
	
	public int getIdPalestrante() {
		return idPalestrante;
	}
	public void setIdPalestrante(int idPalestrante) {
		this.idPalestrante = idPalestrante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
