package br.upe.lapes.acs.discente.api.envelope;

import lombok.Data;

@Data
public class RespostaEntregaCertificadoEnvelope {

	private String mensagem;
	
	public RespostaEntregaCertificadoEnvelope() {
		super();
	}
	
	public RespostaEntregaCertificadoEnvelope(String mensagem) {
		this();
		this.mensagem = mensagem;
	}
}
