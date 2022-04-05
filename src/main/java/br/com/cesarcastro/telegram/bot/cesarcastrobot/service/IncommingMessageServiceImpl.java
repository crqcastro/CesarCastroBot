package br.com.cesarcastro.telegram.bot.cesarcastrobot.service;

import java.math.BigDecimal;
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
import org.springframework.web.client.RestTemplate;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.dao.ChatDao;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.dao.DialogDao;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.dao.MensagemDao;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.dao.UserDao;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.enums.TelegramEndpointEnum;
import br.com.cesarcastro.telegram.bot.cesarcastrobot.model_.IncommingModel;

@Service
public class IncommingMessageServiceImpl implements IncommingMessageService {

	private final RestTemplate restTemplate;
	private final String urlBase;

	private MensagemDao mensagemDao;
	private DialogDao dialogDao;
	private ChatDao chatDao;
	private UserDao userDao;
	private OutcommingMessagService outcomming;

	@Autowired
	public IncommingMessageServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate,
			@Value("${telegram.key}") String botCode, @Value("${telegram.url}") String urlBase, MensagemDao mensagemDao,
			DialogDao dialogDao, ChatDao chatDao, UserDao userDao, OutcommingMessagService outcomming) {
		this.restTemplate = restTemplate;
		this.urlBase = urlBase.replace("<<token>>", botCode).concat(TelegramEndpointEnum.NEW_MESSAGES.getPath());
		this.mensagemDao = mensagemDao;
		this.dialogDao = dialogDao;
		this.chatDao = chatDao;
		this.userDao = userDao;
		this.outcomming = outcomming;
	}

	@Override
	public void processNewMessage() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, headers);

		String url = urlBase.concat(this.getLastMensagem().toString());

		ResponseEntity<IncommingModel> exchange = restTemplate.exchange(
				url, HttpMethod.GET, requestEntity,
				IncommingModel.class);
		IncommingModel body = exchange.getBody();
		
		if(body!==null) {
		body.getResult().forEach(d -> {
			
			if(this.existsMensagem(d.getMensagem().getId())) {
				this.outcomming.processarResposta(d.getMensagem().getChat().getId(), "Mensagem atualizada");
			}else {
				this.outcomming.processarResposta(d.getMensagem().getChat().getId(), null);
				
			}
			userDao.save(d.getMensagem().getUsuario());
			chatDao.save(d.getMensagem().getChat());
			mensagemDao.save(d.getMensagem());
			dialogDao.save(d);
		});}
		
	}

	public Long getLastMensagem() {
		Long max = this.dialogDao.max();
		return max == null ? 0L : max;
	}

	public Boolean existsMensagem(Long id) {
		return mensagemDao.existe(id).equals(1) ? Boolean.TRUE : Boolean.FALSE;
	}
}
