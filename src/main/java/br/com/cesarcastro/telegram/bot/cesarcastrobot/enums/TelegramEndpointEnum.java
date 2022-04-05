package br.com.cesarcastro.telegram.bot.cesarcastrobot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TelegramEndpointEnum {

	NEW_MESSAGES("getUpdates?offset="),
	SEND_RESPONSE("sendMessage?chat_id=<<chat_id>>&text=");
	
	@Getter
	private String path;
}
