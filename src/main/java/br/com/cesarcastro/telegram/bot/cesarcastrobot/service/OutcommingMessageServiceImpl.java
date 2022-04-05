package br.com.cesarcastro.telegram.bot.cesarcastrobot.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.enums.TelegramEndpointEnum;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.OutcommingModel;

@Service
public class OutcommingMessageServiceImpl implements OutcommingMessagService {

	private final RestTemplate restTemplate;
	private final String urlBase;
	
	@Autowired
	public OutcommingMessageServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate,
			@Value("${telegram.key}") String botCode, @Value("${telegram.url}") String urlBase) {
		this.restTemplate = restTemplate;
		this.urlBase = urlBase.replace("<<token>>", botCode).concat(TelegramEndpointEnum.SEND_RESPONSE.getPath());
	}
	
	public void processarResposta(Long idDialog, String msg) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, headers);
		
		System.out.println("-------");
		System.out.println(msg);
		System.out.println("-------");
		
		String url = this.urlBase.replace("<<chat_id>>", idDialog.toString());
		
		String text = "Olá! Eu sou o atendimento automático de teste do Cesar Castro. \n Selecione uma opção:\n"
				+ "1 - Ver cardápio \n2 - Acompanhar pedido \n3 - Outras opções";
		
		String msgFinal = StringUtils.isEmpty(msg)?text:msg;
		
		System.out.println(msgFinal);
		ResponseEntity<OutcommingModel> exchange = restTemplate.exchange(
				url.concat(msgFinal), HttpMethod.GET, requestEntity,
				OutcommingModel.class);
		
		System.out.println(exchange.getStatusCode());
	}
}
