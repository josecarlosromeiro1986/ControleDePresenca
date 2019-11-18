package br.com.controledepresenca.mvc.model.persistent_object;

import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;

public class POControle extends AbstractPersistentObject{
	
	/*
	+----------------+----------+------+-----+---------+----------------+
	| Field          | Type     | Null | Key | Default | Extra          |
	+----------------+----------+------+-----+---------+----------------+
	| id             | int(11)  | NO   | PRI | NULL    | auto_increment |
	| data_entrada   | datetime | NO   |     | NULL    |                |
	| data_saida     | datetime | NO   |     | NULL    |                |
	| idParticipante | int(11)  | NO   |     | NULL    |                |
	| idPalestra     | int(11)  | NO   |     | NULL    |                |
	+----------------+----------+------+-----+---------+----------------+
	*/
	
	protected int idControle;
	protected int idParticipante;
	protected int idPalestra;
	protected String data_entrada;
	protected String data_saida;
	
	public int getIdControle() {
		return idControle;
	}
	public void setIdControle(int idControle) {
		this.idControle = idControle;
	}
	public int getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}
	public int getIdPalestra() {
		return idPalestra;
	}
	public void setIdPalestra(int idPalestra) {
		this.idPalestra = idPalestra;
	}
	public String getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	public String getData_saida() {
		return data_saida;
	}
	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}
	
	public String toString() {
		return idControle + " - " + data_entrada + " - " + idParticipante + " - " + idPalestra + " - " + data_entrada;
	}
}
