package br.upe.lapes.acs.discente.api.envelope;

import br.upe.lapes.acs.discente.negocio.modelo.Eixo;
import br.upe.lapes.acs.discente.negocio.modelo.EntregaCertificadoDTO;
import lombok.Data;

@Data
public class EntregaCertificadoEnvelope {
	private String cpf;
	private Eixo eixo;

	public EntregaCertificadoDTO getEntregaCertificadoDTO() {
		return EntregaCertificadoDTO.builder().cpf(cpf).eixo(eixo).build();
	}
}
