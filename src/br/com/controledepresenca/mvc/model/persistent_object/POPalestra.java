package br.com.controledepresenca.mvc.model.persistent_object;

public class POPalestra {
	
	/*
	+----------------+--------------+------+-----+---------+----------------+
	| Field          | Type         | Null | Key | Default | Extra          |
	+----------------+--------------+------+-----+---------+----------------+
	| id             | int(11)      | NO   | PRI | NULL    | auto_increment |
	| descricao      | varchar(145) | NO   |     | NULL    |                |
	| data_palestra  | datetime     | NO   |     | NULL    |                |
	| id_palestrante | int(11)      | NO   |     | NULL    |                |
	+----------------+--------------+------+-----+---------+----------------+
	*/
	
	protected int idPalestra;
	protected int idPalestrante;
	protected String data_palestra;
	protected String descricao;
	
	public int getIdPalestra() {
		return idPalestra;
	}
	public void setIdPalestra(int idPalestra) {
		this.idPalestra = idPalestra;
	}
	public int getIdPalestrante() {
		return idPalestrante;
	}
	public void setIdPalestrante(int idPalestrante) {
		this.idPalestrante = idPalestrante;
	}
	public String getData_palestra() {
		return data_palestra;
	}
	public void setData_palestra(String data_palestra) {
		this.data_palestra = data_palestra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
