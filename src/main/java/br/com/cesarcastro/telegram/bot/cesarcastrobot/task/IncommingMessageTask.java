package br.com.cesarcastro.telegram.bot.cesarcastrobot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.cesarcastro.telegram.bot.cesarcastrobot.service.IncommingMessageService;

@Component
public class IncommingMessageTask {

	private static final Logger log = LoggerFactory.getLogger(IncommingMessageTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	private IncommingMessageService service;

	public IncommingMessageTask(IncommingMessageService service) {
		this.service = service;
	}
	
	@Scheduled(fixedRate = 10000)
	public void processNewMessages() {
		service.processNewMessage();
	}
	
}
