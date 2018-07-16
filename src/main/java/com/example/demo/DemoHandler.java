package com.example.demo;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_PDF;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import reactor.core.publisher.Mono;

public class DemoHandler {
	public Mono<ServerResponse> getpdf(ServerRequest request) {
		 Resource pdfFile = new ClassPathResource("/test.pdf");
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentDispositionFormData( "attachment", pdfFile.getFilename());
		return ServerResponse.ok().contentType(APPLICATION_PDF).body(fromObject(pdfFile));
	}
}
