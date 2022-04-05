package br.com.cesarcastro.telegram.bot.cesarcastrobot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusEnum {

	ACTIVE(0), 
	CANCELED(1), 
	IN_PREPARATION(2), 
	LEFT_FOR_DELIVERY(3), 
	READY(4), 
	FINISHED(5), 
	WAITING_FOR_ACCEPTANCE(6), 
	PENDING_PAYMENT(7);
	
	@Getter
	private Integer code;
}
