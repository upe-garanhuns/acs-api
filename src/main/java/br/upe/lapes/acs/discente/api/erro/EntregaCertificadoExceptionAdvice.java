package br.upe.lapes.acs.discente.api.erro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.upe.lapes.acs.discente.api.envelope.RespostaEntregaCertificadoEnvelope;

@ControllerAdvice
public class EntregaCertificadoExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<RespostaEntregaCertificadoEnvelope> trataTamanhoMaxExcedidoException(MaxUploadSizeExceededException exc) {
		//FIXME: obter o valor do tamanho máximo de arquivo do que está configurado no arquivo application.properties
		
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new RespostaEntregaCertificadoEnvelope("A capacidade máxima do arquivo foi excedida!"));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespostaEntregaCertificadoEnvelope> trataException(Exception exc) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RespostaEntregaCertificadoEnvelope("Ocorreu um erro ao processar o envio do certificado"));
	}
}
