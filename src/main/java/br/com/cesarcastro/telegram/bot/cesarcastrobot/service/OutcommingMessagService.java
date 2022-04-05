package br.com.cesarcastro.telegram.bot.cesarcastrobot.service;

import org.springframework.stereotype.Service;

@Service
public interface OutcommingMessagService {

	public void processarResposta(Long id, String string);
	
}
