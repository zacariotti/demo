package com.example.demo;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetValidaCpfRequest;
import io.spring.guides.gs_producing_web_service.GetValidaCpfResponse;

@Endpoint
public class CpfValidationEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getValidaCpfRequest")
	@ResponsePayload
	public GetValidaCpfResponse getCountry(@RequestPayload GetValidaCpfRequest request) {
		GetValidaCpfResponse response = new GetValidaCpfResponse();
		response.setEValido(Util.isValidCPF(request.getCpf()));

		return response;
	}
}