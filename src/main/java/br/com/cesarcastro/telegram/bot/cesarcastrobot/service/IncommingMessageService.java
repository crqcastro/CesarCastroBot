package br.com.cesarcastro.telegram.bot.cesarcastrobot.service;

import org.springframework.stereotype.Service;

@Service
public interface IncommingMessageService {

	void processNewMessage();

}
