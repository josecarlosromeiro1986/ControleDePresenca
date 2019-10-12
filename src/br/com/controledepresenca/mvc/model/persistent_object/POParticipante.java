package br.com.controledepresenca.mvc.model.persistent_object;

public class POParticipante {

	protected int codParticipante;
	protected String nomeParticipante;
	protected String foneParticipante;
	
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
