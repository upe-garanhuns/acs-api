package br.upe.lapes.acs.discente.negocio.modelo;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EntregaCertificadoDTO {
	private String cpf;
	private Eixo eixo;
	private List<CertificadoDTO> certificados;
}
