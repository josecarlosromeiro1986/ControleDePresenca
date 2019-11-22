package br.com.controledepresenca.mvc.model.persistent_object;

import br.com.controledepresenca.mvc.model.persistent_object.AbstractPersistentObject;

public class POParticipante extends AbstractPersistentObject{

	/*
	+------------+--------------+------+-----+---------+----------------+
	| Field      | Type         | Null | Key | Default | Extra          |
	+------------+--------------+------+-----+---------+----------------+
	| codigo     | int(11)      | NO   | PRI | NULL    | auto_increment |
	| nome       | varchar(100) | NO   |     | NULL    |                |
	| cpf        | varchar(11)  | NO   |     | NULL    |                |
	| fone       | varchar(9)   | NO   |     | NULL    |                |
	| idPalestra | int(11)      | NO   |     | NULL    |                |
	+------------+--------------+------+-----+---------+----------------+
	 */

	protected int codParticipante;
	protected String nomeParticipante;
	protected String cpfParticipante;
	protected String foneParticipante;
	protected int idPalestra;
	
	public POParticipante(int Codigo, String nome)
	{
		this.nomeParticipante = nome;
		this.codParticipante = Codigo;
	}

	public String getCpfParticipante() {
		return cpfParticipante;
	}
	public void setCpfParticipante(String cpfParticipante) {
		this.cpfParticipante = cpfParticipante;
	}
	public int getIdPalestra() {
		return idPalestra;
	}
	public void setIdPalestra(int idPalestra) {
		this.idPalestra = idPalestra;
	}	
	public int getCodParticipante() {
		return codParticipante;
	}
	public void setCodParticipante(int codParticipante) {
		this.codParticipante = codParticipante;
	}
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getFoneParticipante() {
		return foneParticipante;
	}
	public void setFoneParticipante(String foneParticipante) {
		this.foneParticipante = foneParticipante;
	}	
}
