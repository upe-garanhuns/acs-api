package br.upe.lapes.acs.discente.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.upe.lapes.acs.discente.api.envelope.RespostaEntregaCertificadoEnvelope;
import br.upe.lapes.acs.discente.negocio.modelo.CertificadoDTO;
import br.upe.lapes.acs.discente.negocio.modelo.Eixo;
import br.upe.lapes.acs.discente.negocio.modelo.EntregaCertificadoDTO;
import br.upe.lapes.acs.discente.negocio.servico.IDiscenteServico;

@RestController
@RequestMapping("/acs-api/v1/discente")
@CrossOrigin("*")
public class DiscenteAPI {

	@Autowired
	private IDiscenteServico servico;

	@GetMapping("/")
	public void teste() {
		System.out.println("chegou");
	}

	@PostMapping(value = "/enviarcertificado", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<RespostaEntregaCertificadoEnvelope> enviarCertificado(
			@RequestPart(value = "arquivos", required = true) MultipartFile[] arquivos,
			@RequestParam(value = "cpf", required = true) String cpf, @RequestParam(value = "eixo", required = true) Eixo eixo) {

		try {

			List<CertificadoDTO> certificados = null;

			if (arquivos != null) {
				certificados = new ArrayList<>();

				for (MultipartFile arquivo : arquivos) {
					certificados.add(CertificadoDTO.builder().certificado(arquivo.getBytes()).build());
				}
			}

			EntregaCertificadoDTO dto = EntregaCertificadoDTO.builder().cpf(cpf)
					.eixo(eixo).certificados(certificados).build();
			
			servico.enviarCertificado(dto);

			return ResponseEntity.status(HttpStatus.OK).body(new RespostaEntregaCertificadoEnvelope());

		} catch (IOException e) {
			throw new RuntimeException("Ocorreu um erro ao obter os dados para envio do(s) certificado(s)", e);
		}

	}

}
