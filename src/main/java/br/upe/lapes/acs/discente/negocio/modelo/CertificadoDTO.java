package br.upe.lapes.acs.discente.negocio.modelo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CertificadoDTO {
	private Discente discente;
	private byte[] certificado;
	private Eixo eixo;
}
